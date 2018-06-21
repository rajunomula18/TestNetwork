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
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface PartnerServiceV5 {
    @GET("api/v5/partners")
    Call<ResponseBody> getPartnerList(@QueryMap Map<String, String> params);

    @POST("/api/v5/partners/{partnerId}/link")
    Call<ResponseBody> linkPartner(@Path("partnerId") String partnerId);

    @DELETE("/api/v5/partners/{partnerId}/unlink")
    Call<ResponseBody> unlinkPartner(@Path("partnerId") String partnerId);
}
