/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network.framework.network;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class HeaderInterceptor implements Interceptor {

    public static final String SECURITY_TOKEN_HEADER = "SecurityToken";

    private String securityToken;
    private final String applicationId;

    public HeaderInterceptor(String securityToken, String applicationId) {
        this.securityToken = securityToken;
        this.applicationId = applicationId;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder()
                .addHeader("MyQApplicationId", applicationId)
                .addHeader("Content-Type", "application/json");

        if (securityToken != null && !securityToken.isEmpty()) {
            requestBuilder.addHeader(SECURITY_TOKEN_HEADER, securityToken);
        }

        return chain.proceed(requestBuilder.build());
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }
}
