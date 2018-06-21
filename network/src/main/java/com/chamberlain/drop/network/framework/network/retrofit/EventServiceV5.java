/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network.framework.network.retrofit;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface EventServiceV5 {
    @GET("api/v5/accounts/{accountId}/eventhistory")
    Call<ResponseBody> getEventHistory(@Path("accountId") String accountId,
                                       @QueryMap Map<String, String> params);

    @GET("api/v5/accounts/{accountId}/eventhistory/{eventId}")
    Call<ResponseBody> getEventHistory(@Path("accountId") String accountId,
                                       @Path("eventId") String eventId);

    @GET("api/v5/accounts/{accountId}/eventhistory/{eventId}")
    Call<ResponseBody> getDropEventHistory(@Path("accountId") String accountId,
                                           @Path("eventId") String eventId);

    @DELETE("api/v5/accounts/{accountId}/eventhistory")
    Call<ResponseBody> deleteEventHistory(@Path("accountId") String accountId,
                                          @QueryMap Map<String, String> params);
}
