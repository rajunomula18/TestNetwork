/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service;

import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework.RawNetworkCallback;
import com.chamberlain.drop.network.framework.network.retrofit.DeviceServiceV5;
import com.chamberlain.drop.network.framework.service.contract.IDeviceService;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class DeviceService extends BaseService implements IDeviceService {

    private DeviceServiceV5 deviceServiceV5;

    public DeviceService(DeviceServiceV5 deviceServiceV5) {
        this.deviceServiceV5 = deviceServiceV5;
    }

    @Override
    public void getDeviceDetailsList(@NonNull String accountId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = deviceServiceV5.getDeviceDetailsList(accountId);
        processCall(call, callback);
    }

    @Override
    public void getDeviceDetails(@NonNull String accountId, @NonNull String serialNumber, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = deviceServiceV5.getDeviceDetails(accountId, serialNumber);
        processCall(call, callback);
    }

    @Override
    public void registerGateway(@NonNull String accountId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = deviceServiceV5.registerGateway(accountId, createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void deviceAction(@NonNull String accountId, @NonNull String deviceId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = deviceServiceV5.deviceAction(accountId, deviceId, createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void getMivCameraEvents(@NonNull String accountId, @NonNull String serialNumber, int pageNumber, int pageSize, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = deviceServiceV5.getMivCameraEvents(accountId, serialNumber, pageNumber, pageSize);
        processCall(call, callback);
    }

    @Override
    public void getMivCameraLogin(@NonNull String accountId, @NonNull String serialNumber, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = deviceServiceV5.getMivCameraLogin(accountId, serialNumber);
        processCall(call, callback);
    }

    @Override
    public void removeDevice(@NonNull String accountId, @NonNull String deviceId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = deviceServiceV5.removeDevice(accountId, deviceId);
        processCall(call, callback);
    }

    @Override
    public void updateDeviceName(@NonNull String accountId, @NonNull String deviceId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = deviceServiceV5.updateDeviceName(accountId, deviceId, createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void getDeviceKeys(@NonNull String accountId, @NonNull String serialNumber, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = deviceServiceV5.getDeviceKeys(accountId, serialNumber);
        processCall(call, callback);
    }

    @Override
    public void registerIntellivisionCamera(@NonNull String accountId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = deviceServiceV5.registerIntellivisionCamera(accountId, createRequestBody(jsonBody));
        processCall(call, callback);
    }
}
