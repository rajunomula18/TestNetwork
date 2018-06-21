/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network.framework;

import android.support.annotation.Nullable;
import android.util.Log;

import com.chamberlain.drop.network.framework.network.HeaderInterceptor;
import com.chamberlain.drop.network.framework.network.NetworkResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.CountDownLatch;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class TokenAuthenticatorHelper implements Authenticator {

    private static final String TAG = TokenAuthenticatorHelper.class.getSimpleName();
    private static final String PASSWORD = "password";
    private static final String USERNAME = "username";
    private static final String SECURITY_TOKEN = "SecurityToken";

    private INetworkFramework networkFramework;

    public void setNetworkFramework(INetworkFramework networkFramework) {
        this.networkFramework = networkFramework;
    }

    @Nullable
    @Override
    public Request authenticate(Route route, Response response) {
        if (response.request().header(HeaderInterceptor.SECURITY_TOKEN_HEADER) != null) {
            return null; // Give up, we've already failed to authenticate.
        }
        final String[] resultSecurityTokens = new String[1];
        ICredentialsProvider credentialsProvider = networkFramework != null ? networkFramework.getCredentialsProvider() : null;
        String userName = credentialsProvider != null ? credentialsProvider.getUserName() : null;
        String password = credentialsProvider != null ? credentialsProvider.getPassword() : null;
        if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            JSONObject postParams = new JSONObject();
            try {
                postParams.put(USERNAME, userName);
                postParams.put(PASSWORD, password);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            networkFramework.userService().logUserIn(postParams.toString(), new INetworkFramework.RawNetworkCallback() {
                @Override
                public void onResponse(NetworkResponse response) {
                    if (response.isSuccessful() && response.body() != null) {
                        try {
                            String res = response.body();
                            JSONObject jsonObject = new JSONObject(res);
                            String token = jsonObject.getString(SECURITY_TOKEN);
                            resultSecurityTokens[0] = token;
                            credentialsProvider.onRefreshSecurityToken(resultSecurityTokens[0]);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    countDownLatch.countDown();
                }

                @Override
                public void onFailure(Throwable t) {
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String securityToken = resultSecurityTokens[0];
        if (securityToken == null || securityToken.isEmpty()) {
            //unauthenticated response will be returned to the caller that triggered it.
            return null;
        }
        Log.i(TAG, securityToken);
        return response.request().newBuilder().header(HeaderInterceptor.SECURITY_TOKEN_HEADER, securityToken).build();
    }
}
