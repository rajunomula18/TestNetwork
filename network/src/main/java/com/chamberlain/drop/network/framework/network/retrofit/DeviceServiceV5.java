/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network.framework.network.retrofit;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DeviceServiceV5 {
    @GET("/api/v5/Accounts/{accountId}/Devices")
    Call<ResponseBody> getDeviceDetailsList(@Path(value = "accountId", encoded = true) String accountId);


    @GET("/api/v5.1/Accounts/{accountId}/Devices/{serialNumber}")
    Call<ResponseBody> getDeviceDetails(@Path(value = "accountId", encoded = true) String accountId,
                                        @Path(value = "serialNumber", encoded = true) String serialNumber);

    @POST("/api/v5/Accounts/{accountId}/Devices")
    Call<ResponseBody> registerGateway(@Path(value = "accountId", encoded = true) String accountId, @Body RequestBody requestBody);

    @PUT("/api/v5.1/Accounts/{accountId}/Devices/{deviceId}/Actions")
    Call<ResponseBody> deviceAction(@Path(value = "accountId", encoded = true) String accountId,
                                    @Path(value = "deviceId", encoded = true) String deviceId,
                                    @Body RequestBody requestBody);

    @GET("/api/v5/Accounts/{accountId}/Devices/cameras/{serialNumber}/events")
    Call<ResponseBody> getMivCameraEvents(@Path(value = "accountId", encoded = true) String accountId,
                                          @Path(value = "serialNumber", encoded = true) String serialNumber,
                                          @Query(value = "pageNumber", encoded = true) int pageNumber,
                                          @Query(value = "pageSize", encoded = true) int pageSize);

    @GET("/api/v5/Accounts/{accountId}/Devices/cameras/{serialNumber}/stream")
    Call<ResponseBody> getMivCameraLogin(@Path(value = "accountId", encoded = true) String accountId,
                                         @Path(value = "serialNumber", encoded = true) String serialNumber);

    @DELETE("/api/v5.1/Accounts/{accountId}/Devices/{deviceId}")
    Call<ResponseBody> removeDevice(@Path(value = "accountId", encoded = true) String accountId,
                                    @Path(value = "deviceId", encoded = true) String deviceId);

    @PUT("/api/v5.1/Accounts/{accountId}/Devices/{deviceId}")
    Call<ResponseBody> updateDeviceName(@Path(value = "accountId", encoded = true) String accountId,
                                        @Path(value = "deviceId", encoded = true) String deviceId,
                                        @Body RequestBody requestBody);

    @GET("/api/v5/accounts/{accountId}/providers/intellivision/devices/{serialNumber}")
    Call<ResponseBody> getDeviceKeys(@Path(value = "accountId", encoded = true) String accountId,
                                     @Path(value = "serialNumber", encoded = true) String serialNumber);

    @PUT("/api/v5/accounts/{accountId}/providers/intellivision/devices")
    Call<ResponseBody> registerIntellivisionCamera(@Path(value = "accountId", encoded = true) String accountId,
                                                   @Body RequestBody requestBody);

}
