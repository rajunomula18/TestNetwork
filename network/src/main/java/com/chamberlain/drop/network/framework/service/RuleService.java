/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service;

import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework.RawNetworkCallback;
import com.chamberlain.drop.network.framework.network.retrofit.RuleServiceV5;
import com.chamberlain.drop.network.framework.service.contract.IRuleService;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class RuleService extends BaseService implements IRuleService {
    private RuleServiceV5 ruleServiceV5;

    public RuleService(RuleServiceV5 ruleServiceV5) {
        this.ruleServiceV5 = ruleServiceV5;
    }

    @Override
    public void getAlertList(@NonNull String accountId, @NonNull String userId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = ruleServiceV5.getAlertList(accountId, userId);
        processCall(call, callback);
    }

    @Override
    public void createAlert(@NonNull String accountId, @NonNull String userId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = ruleServiceV5.createAlert(accountId, userId, createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void updateAlert(@NonNull String accountId, @NonNull String userId, @NonNull String alertNotificationId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = ruleServiceV5.updateAlert(accountId, userId, alertNotificationId, createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void deleteAlert(@NonNull String accountId, @NonNull String userId, @NonNull String alertNotificationId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = ruleServiceV5.deleteAlert(accountId, userId, alertNotificationId);
        processCall(call, callback);
    }

    @Override
    public void testAlert(@NonNull String accountId, @NonNull String userId, @NonNull String alertNotificationId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = ruleServiceV5.testAlert(accountId, userId, alertNotificationId, createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void getScene(@NonNull String accountId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = ruleServiceV5.getScene(accountId);
        processCall(call, callback);
    }

    @Override
    public void createScene(@NonNull String accountId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = ruleServiceV5.createScene(accountId, createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void updateScene(@NonNull String accountId, @NonNull String scheduleId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = ruleServiceV5.updateScene(accountId, scheduleId, createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void deleteScene(@NonNull String accountId, @NonNull String scheduleId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = ruleServiceV5.deleteScene(accountId, scheduleId);
        processCall(call, callback);
    }
}
