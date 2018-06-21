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

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface VGDOServiceV5 {
    @GET("api/v5.1/accounts/{accountId}/devices/{deviceId}/programmable_devices")
    Call<ResponseBody> getAvailableVGDOs(@Path("accountId") String accountId,
                                         @Path("deviceId") String deviceId);

    @GET("api/v5.1/accounts/{accountId}/devices/{deviceId}/sensor_connected")
    Call<ResponseBody> getSensorConnectionStatus(@Path("accountId") String accountId,
                                                 @Path("deviceId") String deviceId,
                                                 @QueryMap Map<String, String> params);

    @PUT("api/v5.1/accounts/{accountId}/devices/{deviceId}/start_learn_process")
    Call<ResponseBody> startSensorLearnProcess(@Path("accountId") String accountId,
                                               @Path("deviceId") String deviceId);

    @GET("api/v5/oemtx/questions")
    Call<ResponseBody> getBrandQuestions(@QueryMap Map<String, String> params);

    @PUT("api/v5.1/accounts/{accountId}/devices/{deviceId}/start_workflow")
    Call<ResponseBody> startLearningDoor(@Path("accountId") String accountId,
                                         @Path("deviceId") String deviceId,
                                         @Body RequestBody requestBody);

    @GET("api/v5.1/accounts/{accountId}/devices/{deviceId}/workflow_status")
    Call<ResponseBody> getWorkFlowStatus(@Path("accountId") String accountId,
                                         @Path("deviceId") String deviceId);

    @PUT("api/v5.1/accounts/{accountId}/devices/{deviceId}/continue_workflow")
    Call<ResponseBody> continueLearningDoor(@Path("accountId") String accountId,
                                            @Path("deviceId") String deviceId);

    @PUT("api/v5.1/accounts/{accountId}/devices/{deviceId}/cancel_workflow")
    Call<ResponseBody> cancelLearningDoor(@Path("accountId") String accountId,
                                          @Path("deviceId") String deviceId);
}
