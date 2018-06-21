/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service;

import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework;
import com.chamberlain.drop.network.framework.network.retrofit.PartnerServiceV5;
import com.chamberlain.drop.network.framework.service.contract.IPartnerService;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class PartnerService extends BaseService implements IPartnerService {

    private PartnerServiceV5 partnerServiceV5;

    public PartnerService(PartnerServiceV5 partnerServiceV5) {
        this.partnerServiceV5 = partnerServiceV5;
    }

    @Override
    public void getPartnerList(@NonNull Map<String, String> params, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = partnerServiceV5.getPartnerList(params);
        processCall(call, callback);
    }

    @Override
    public void linkPartner(@NonNull String partnerId, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = partnerServiceV5.linkPartner(partnerId);
        processCall(call, callback);
    }

    @Override
    public void unlinkPartner(@NonNull String partnerId, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = partnerServiceV5.unlinkPartner(partnerId);
        processCall(call, callback);
    }
}
