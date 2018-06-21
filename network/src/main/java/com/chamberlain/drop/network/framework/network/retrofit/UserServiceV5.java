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
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface UserServiceV5 {
    @POST("api/v5/login")
    Call<ResponseBody> logUserIn(@Body RequestBody loginBody);

    @PUT("api/v5/Login/CompleteRegistration")
    Call<ResponseBody> verifyUser(@Body RequestBody verifyBody);

    @GET("api/v5/Timezones")
    Call<ResponseBody> getTimezones();

    @GET("api/v5/Countries")
    Call<ResponseBody> getCountries();

    @POST("api/v5/Users")
    Call<ResponseBody> createUser(@Body RequestBody userBody);

    @PUT("api/v5/My/Email")
    Call<ResponseBody> changeEmail(@Body RequestBody emailBody);

    @POST("api/v5/My/Email/ConfirmChange")
    Call<ResponseBody> changePushEmail(@Body RequestBody emailBody);

    @POST("api/v5/Login/resetPassword")
    Call<ResponseBody> resetPassword(@Body RequestBody emailBody);

    @POST("api/v5/Login/changePassword")
    Call<ResponseBody> changePassword(@Body RequestBody passwordBody);

    @POST("api/v5/Login/resendregistrationemail")
    Call<ResponseBody> resendRegistrationConfirmation(@Body RequestBody passwordBody);

    @GET("api/v5/My")
    Call<ResponseBody> getUserProfile(@QueryMap Map<String, String> params);

    @PUT("api/v5/My")
    Call<ResponseBody> updateUserProfile(@Body RequestBody userBody);

    @PUT("api/v5/My/smartdevices/{smartDeviceUUID}")
    Call<ResponseBody> registerSmartDevices(@Path(value = "smartDeviceUUID", encoded = true) String smartDeviceUUID, @Body RequestBody deviceBody);

    @DELETE("api/v5/My/smartdevices/{smartDeviceUUID}")
    Call<ResponseBody> deleteSmartDevices(@Path(value = "smartDeviceUUID", encoded = true) String smartDeviceUUID);

    @GET("api/v5/My/smartdevices/{smartDeviceUUID}/tags")
    Call<ResponseBody> getSmartDevicesTags(@Path(value = "smartDeviceUUID", encoded = true) String smartDeviceUUID);

    @GET("api/v5/userdataprotection")
    Call<ResponseBody> getGDPRComplianceStatus();

    @PUT("api/v5/userdataprotection/acceptterms")
    Call<ResponseBody> acceptGDPRToS();

    @PUT("api/v5/userdataprotection/request")
    Call<ResponseBody> updateGDPRPrivacyConsent(@Body RequestBody requestBody);

    @GET("api/v5/contents")
    Call<ResponseBody> getRegionContent(@Query(value = "name", encoded = true) String name,
                                        @Query(value = "Brand", encoded = true) String brand,
                                        @Query(value = "Region", encoded = true) String region);

}
