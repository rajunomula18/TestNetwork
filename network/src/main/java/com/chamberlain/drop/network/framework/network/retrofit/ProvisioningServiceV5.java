/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.network.retrofit;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ProvisioningServiceV5 {

    @GET("jstart")
    Call<ResponseBody> getApiVersion();

    @GET("jscan_results")
    Call<ResponseBody> scanWiFiNetworks();

    @GET("jconfig_save")
    Call<ResponseBody> saveConfig(@QueryMap Map<String, String> params);

    @GET("jconnect_serial")
    Call<ResponseBody> getSerialNumber();
}
