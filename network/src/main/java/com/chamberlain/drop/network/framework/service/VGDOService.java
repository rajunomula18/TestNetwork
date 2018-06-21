/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service;

import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework.RawNetworkCallback;
import com.chamberlain.drop.network.framework.network.retrofit.VGDOServiceV5;
import com.chamberlain.drop.network.framework.service.contract.IVGDOService;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class VGDOService extends BaseService implements IVGDOService {

    private VGDOServiceV5 vgdoServiceV5;

    public VGDOService(VGDOServiceV5 vgdoServiceV5) {
        this.vgdoServiceV5 = vgdoServiceV5;
    }

    @Override
    public void getAvailableVGDOs(@NonNull String accountId, @NonNull String deviceId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = vgdoServiceV5.getAvailableVGDOs(accountId, deviceId);
        processCall(call, callback);
    }

    @Override
    public void getSensorConnectionStatus(@NonNull String accountId, @NonNull String deviceId, @NonNull Map<String, String> params, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = vgdoServiceV5.getSensorConnectionStatus(accountId, deviceId, params);
        processCall(call, callback);
    }

    @Override
    public void startSensorLearnProcess(@NonNull String accountId, @NonNull String deviceId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = vgdoServiceV5.startSensorLearnProcess(accountId, deviceId);
        processCall(call, callback);
    }

    @Override
    public void getBrandQuestions(@NonNull Map<String, String> params, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = vgdoServiceV5.getBrandQuestions(params);
        processCall(call, callback);
    }

    @Override
    public void startLearningDoor(@NonNull String accountId, @NonNull String deviceId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = vgdoServiceV5.startLearningDoor(accountId, deviceId, createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void getWorkFlowStatus(@NonNull String accountId, @NonNull String deviceId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = vgdoServiceV5.getWorkFlowStatus(accountId, deviceId);
        processCall(call, callback);
    }

    @Override
    public void continueLearningDoor(@NonNull String accountId, @NonNull String deviceId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = vgdoServiceV5.continueLearningDoor(accountId, deviceId);
        processCall(call, callback);
    }

    @Override
    public void cancelLearningDoor(@NonNull String accountId, @NonNull String deviceId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = vgdoServiceV5.cancelLearningDoor(accountId, deviceId);
        processCall(call, callback);
    }
}
