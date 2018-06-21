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

public interface RuleServiceV5 {
    @GET("/api/v5/Accounts/{accountId}/Users/{userId}/Notifications")
    Call<ResponseBody> getAlertList(@Path(value = "accountId", encoded = true) String accountId,
                                    @Path(value = "userId", encoded = true) String userId);

    @POST("/api/v5/Accounts/{accountId}/Users/{userId}/Notifications")
    Call<ResponseBody> createAlert(@Path(value = "accountId", encoded = true) String accountId,
                                   @Path(value = "userId", encoded = true) String userId,
                                   @Body RequestBody requestBody);

    @PUT("/api/v5/Accounts/{accountId}/Users/{userId}/Notifications/{alertNotificationId}")
    Call<ResponseBody> updateAlert(@Path(value = "accountId", encoded = true) String accountId,
                                   @Path(value = "userId", encoded = true) String userId,
                                   @Path(value = "alertNotificationId", encoded = true) String alertNotificationId,
                                   @Body RequestBody requestBody);

    @DELETE("/api/v5/Accounts/{accountId}/Users/{userId}/Notifications/{alertNotificationId}")
    Call<ResponseBody> deleteAlert(@Path(value = "accountId", encoded = true) String accountId,
                                   @Path(value = "userId", encoded = true) String userId,
                                   @Path(value = "alertNotificationId", encoded = true) String alertNotificationId);

    @POST("/api/v5/Accounts/{accountId}/Users/{userId}/Notifications/{alertNotificationId}/Test")
    Call<ResponseBody> testAlert(@Path(value = "accountId", encoded = true) String accountId,
                                 @Path(value = "userId", encoded = true) String userId,
                                 @Path(value = "alertNotificationId", encoded = true) String alertNotificationId,
                                 @Body RequestBody requestBody);

    @GET("/api/v5/Accounts/{accountId}/scenes")
    Call<ResponseBody> getScene(@Path(value = "accountId", encoded = true) String accountId);

    @POST("/api/v5/Accounts/{accountId}/scenes")
    Call<ResponseBody> createScene(@Path(value = "accountId", encoded = true) String accountId,
                                   @Body RequestBody requestBody);

    @PUT("/api/v5/Accounts/{accountId}/scenes/{scheduleId}")
    Call<ResponseBody> updateScene(@Path(value = "accountId", encoded = true) String accountId,
                                   @Path(value = "scheduleId", encoded = true) String scheduleId,
                                   @Body RequestBody requestBody);

    @DELETE("/api/v5/Accounts/{accountId}/scenes/{scheduleId}")
    Call<ResponseBody> deleteScene(@Path(value = "accountId", encoded = true) String accountId,
                                   @Path(value = "scheduleId", encoded = true) String scheduleId);
}
