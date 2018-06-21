/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.network.retrofit;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface DeliveryServiceV5 {

    @POST("api/DeliveryAssociate")
    Call<ResponseBody> createUser(@Body RequestBody createUserBody);

    @GET("api/My")
    Call<ResponseBody> getLoggedInUser();

    @GET("api/DeliveryAssociate/{deliveryAssociateId}/Deliveries")
    Call<ResponseBody> getAllDeliveries(@Path("deliveryAssociateId") String deliveryAssociateId);

    @GET("api/homeowners/{homeownerId}/Deliveries")
    Call<ResponseBody> getHomeownersDeliveries(@Path("homeownerId") String homeownerId);

    @GET("api/DeliveryAssociate/{deliveryAssociateId}/Deliveries/{deliveryId}")
    Call<ResponseBody> getDeliveryById(@Path("deliveryId") String deliveryId,
                                       @Path("deliveryAssociateId") String deliveryAssociateId);

    @PUT("api/DeliveryAssociate/{deliveryAssociateId}/Deliveries/{deliveryId}")
    Call<ResponseBody> updateDeliveryStatus(@Path("deliveryId") String deliveryId,
                                            @Path("deliveryAssociateId") String deliveryAssociateId,
                                            @Body RequestBody statusBody);

    @GET("api/DeliveryAssociate/{deliveryAssociateId}/Deliveries/{deliveryId}/Devices/{deviceSerialNumber}")
    Call<ResponseBody> getDeliveryDeviceDetails(@Path("deliveryId") String deliveryId,
                                                @Path("deliveryAssociateId") String deliveryAssociateId,
                                                @Path("deviceSerialNumber") String deviceSerialNumber);

    @PUT("api/DeliveryAssociate/{deliveryAssociateId}/Deliveries/{deliveryId}/Devices/{deviceSerialNumber}")
    Call<ResponseBody> triggerDeviceState(@Path("deliveryId") String deliveryId,
                                          @Path("deliveryAssociateId") String deliveryAssociateId,
                                          @Path("deviceSerialNumber") String deviceSerialNumber,
                                          @Body RequestBody actionBody);

    @GET("api/my/homeowner")
    Call<ResponseBody> getHomeownerAccount();

    @POST("api/Homeowners")
    Call<ResponseBody> saveHomeownerDeliveryAddress(@Body RequestBody addressBody);

    @GET("api/homeowners/{homeownerId}/partners")
    Call<ResponseBody> getRetailPartners(@Path("homeownerId") String homeownerId);

    @Multipart
    @POST("api/DeliveryAssociate/{deliveryAssociateId}/Deliveries/{deliveryId}/Photo")
    Call<ResponseBody> uploadPhoto(@Path("deliveryId") String deliveryId,
                                   @Path("deliveryAssociateId") String deliveryAssociateId,
                                   @Part MultipartBody.Part body);

    @PUT("api/DeliveryAssociate/{deliveryAssociateId}/SmartDevices/{deviceId}")
    Call<ResponseBody> registerFcmToken(@Path("deliveryAssociateId") String deliveryAssociateId,
                                        @Path("deviceId") String deviceId,
                                        @Body RequestBody fcmRegisterBody);

    @DELETE("api/DeliveryAssociate/{deliveryAssociateId}/SmartDevices/{deviceId}")
    Call<ResponseBody> deleteFcmTokenRegistration(@Path("deliveryAssociateId") String deliveryAssociateId,
                                                  @Path("deviceId") String deviceId);

    @POST("api/DeliveryAssociate/{deliveryAssociateId}/Deliveries/{deliveryId}/Feedback")
    Call<ResponseBody> uploadFeedback(@Path("deliveryId") String deliveryId,
                                      @Path("deliveryAssociateId") String deliveryAssociateId,
                                      @Body RequestBody feedbackBody);

    @PUT("api/HomeOwner/{homeownerId}/SmartDevices/{deviceId}")
    Call<ResponseBody> registerHomeOwnerFcmToken(@Path("homeownerId") String homeownerId,
                                                 @Path("deviceId") String deviceId,
                                                 @Body RequestBody fcmRegisterBody);

    @DELETE("api/HomeOwner/{homeownerId}/SmartDevices/{deviceId}")
    Call<ResponseBody> deleteHomeOwnerFcmTokenRegistration(@Path("homeownerId") String homeownerId,
                                                           @Path("deviceId") String deviceId);

    @POST("api/DeliveryAssociate/{deliveryAssociateId}/Deliveries/{deliveryId}/VerifyLocation")
    Call<ResponseBody> verifyLocation(@Path("deliveryId") String deliveryId,
                                      @Path("deliveryAssociateId") String deliveryAssociateId,
                                      @Body RequestBody verifyLocationBody);

    @GET("api/Homeowners/{homeownerId}/Addresses")
    Call<ResponseBody> getHomeOwnerAddresses(@Path("homeownerId") String homeownerId);

    @POST("api/Homeowners/Address/Validate")
    Call<ResponseBody> validateHomeownerDeliveryAddress(@Body RequestBody address);

    @POST("api/Homeowners")
    Call<ResponseBody> createHomeownerAccount(@Body RequestBody address);

    @PUT("api/DeliveryAssociate/{deliveryAssociateId}/Deliveries/{deliveryId}/Devices/{deviceSerialNumber}")
    Call<ResponseBody> triggerDeviceAction(@Path("deliveryId") String deliveryId,
                                           @Path("deliveryAssociateId") String deliveryAssociateId,
                                           @Path("deviceSerialNumber") String deviceSerialNumber,
                                           @Body RequestBody actionBody);

    @GET("api/Homeowners/{homeownerId}/Addresses/{homeownerAddressId}/Devices/")
    Call<ResponseBody> getAddressDevices(@Path("homeownerId") String homeownerId, @Path("homeownerAddressId") String homeownerAddressId);

    @POST("api/homeowners/{homeownerId}/deliveries/trackingnumber")
    Call<ResponseBody> addDelivery(@Path("homeownerId") String homeownerId, @Body RequestBody body);
}
