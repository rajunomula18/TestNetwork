/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service;

import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework;
import com.chamberlain.drop.network.framework.network.retrofit.ProvisioningServiceV5;
import com.chamberlain.drop.network.framework.service.contract.IProvisioningService;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class ProvisioningService extends BaseService implements IProvisioningService {
    private ProvisioningServiceV5 provisioningServiceV5;

    public ProvisioningService(ProvisioningServiceV5 provisioningServiceV5) {
        this.provisioningServiceV5 = provisioningServiceV5;
    }

    @Override
    public void getApiVersion(@NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = provisioningServiceV5.getApiVersion();
        processCall(call, callback);
    }

    @Override
    public void scanWiFiNetworks(@NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = provisioningServiceV5.scanWiFiNetworks();
        processCall(call, callback);
    }

    @Override
    public void saveConfig(@NonNull Map<String, String> params, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = provisioningServiceV5.saveConfig(params);
        processCall(call, callback);
    }

    @Override
    public void getSerialNumber(@NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = provisioningServiceV5.getSerialNumber();
        processCall(call, callback);
    }
}
