/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service;

import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework;
import com.chamberlain.drop.network.framework.model.PhotoMultipartFormatter;
import com.chamberlain.drop.network.framework.network.retrofit.DeliveryServiceV5;
import com.chamberlain.drop.network.framework.service.contract.IDeliveryService;

import java.io.File;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class DeliveryService extends BaseService implements IDeliveryService {

    private DeliveryServiceV5 deliveryServiceV5;
    private PhotoMultipartFormatter photoMultipartFormatter;

    public DeliveryService(DeliveryServiceV5 deliveryServiceV5, PhotoMultipartFormatter photoMultipartFormatter) {
        this.deliveryServiceV5 = deliveryServiceV5;
        this.photoMultipartFormatter = photoMultipartFormatter;
    }

    /**
     * Retrieve the list of DA deliveries (not Drop deliveries).
     *
     * @param deliveryAssociateId required
     * @param callback            for retieval
     */
    @Override
    public void getAllDeliveries(@NonNull String deliveryAssociateId, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.getAllDeliveries(deliveryAssociateId);
        processCall(call, callback);
    }

    /**
     * Retrieve the list of DA deliveries (not Drop deliveries).
     *
     * @param homeownerId required
     * @param callback    for retieval
     */
    @Override
    public void getHomeownersDeliveries(@NonNull String homeownerId, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.getHomeownersDeliveries(homeownerId);
        processCall(call, callback);
    }

    @Override
    public void getDeliveryById(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.getDeliveryById(deliveryId, deliveryAssociateId);
        processCall(call, callback);
    }

    @Override
    public void updateDeliveryStatus(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull String deliveryStatus, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.updateDeliveryStatus(deliveryId, deliveryAssociateId, createRequestBody(deliveryStatus));
        processCall(call, callback);
    }

    @Override
    public void getDeliveryDeviceDetails(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull String deviceSerialNumber, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.getDeliveryDeviceDetails(deliveryId, deliveryAssociateId, deviceSerialNumber);
        processCall(call, callback);
    }

    @Override
    public void triggerDeviceState(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull String deviceSerialNumber, @NonNull String action, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.triggerDeviceState(deliveryId, deliveryAssociateId, deviceSerialNumber, createRequestBody(action));
        processCall(call, callback);
    }

    @Override
    public void getAddressDevices(@NonNull String homeownerId, @NonNull String homeownerAddressId, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.getAddressDevices(homeownerId, homeownerAddressId);
        processCall(call, callback);
    }

    /**
     * This retrieves the HomeownerAccount object.
     *
     * @param callback for retrieval
     */
    @Override
    public void getHomeownerAccount(@NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.getHomeownerAccount();
        processCall(call, callback);
    }

    @Override
    public void saveHomeownerDeliveryAddress(@NonNull String address, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.saveHomeownerDeliveryAddress(createRequestBody(address));
        processCall(call, callback);
    }


    /**
     * This retrieves the list of RetailPartners.
     *
     * @param homeownerId required
     * @param callback    for retrieval
     */
    @Override
    public void getRetailPartners(@NonNull String homeownerId, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.getRetailPartners(homeownerId);
        processCall(call, callback);
    }

    @Override
    public void uploadPhoto(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull File photo, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.uploadPhoto(deliveryId, deliveryAssociateId, photoMultipartFormatter.formatAsJpeg(photo));
        processCall(call, callback);
    }

    @Override
    public void registerFcmToken(@NonNull String deliveryAssociateId, @NonNull String deviceId, @NonNull String fcmToken, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.registerFcmToken(deliveryAssociateId, deviceId, createRequestBody(fcmToken));
        processCall(call, callback);
    }

    @Override
    public void unregisterFcmToken(@NonNull String deliveryAssociateId, @NonNull String deviceId, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.deleteFcmTokenRegistration(deliveryAssociateId, deviceId);
        processCall(call, callback);
    }

    @Override
    public void uploadFeedback(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull String feedback, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.uploadFeedback(deliveryId, deliveryAssociateId, createRequestBody(feedback));
        processCall(call, callback);
    }

    @Override
    public void createHomeownerAccount(@NonNull String address, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.createHomeownerAccount(createRequestBody(address));
        processCall(call, callback);
    }

    @Override
    public void registerHomeOwnerFcmToken(@NonNull String homeownerId, @NonNull String deviceId, @NonNull String fcmToken, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.registerHomeOwnerFcmToken(homeownerId, deviceId, createRequestBody(fcmToken));
        processCall(call, callback);
    }

    @Override
    public void unregisterHomeOwnerFcmToken(@NonNull String homeOwnerId, @NonNull String deviceId, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.deleteHomeOwnerFcmTokenRegistration(homeOwnerId, deviceId);
        processCall(call, callback);
    }

    @Override
    public void triggerDeviceAction(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull String deviceSerialNumber,
                                    @NonNull String actionBody, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.triggerDeviceAction(deliveryId, deliveryAssociateId, deviceSerialNumber, createRequestBody(actionBody));
        processCall(call, callback);
    }

    @Override
    public void verifyLocation(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull String verifyLocationBody,
                               @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.verifyLocation(deliveryId, deliveryAssociateId, createRequestBody(verifyLocationBody));
        processCall(call, callback);
    }

    @Override
    public void getHomeOwnerAddresses(@NonNull String homeownerId, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.getHomeOwnerAddresses(homeownerId);
        processCall(call, callback);
    }

    @Override
    public void validateHomeownerAddress(@NonNull String homeownerAddressBody, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.validateHomeownerDeliveryAddress(createRequestBody(homeownerAddressBody));
        processCall(call, callback);
    }

    @Override
    public void getLoggedInUser(@NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.getLoggedInUser();
        processCall(call, callback);
    }

    @Override
    public void createUser(@NonNull String jsonUser, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.createUser(createRequestBody(jsonUser));
        processCall(call, callback);
    }

    @Override
    public void addDelivery(@NonNull String homeownerId, @NonNull String jsonTrackingNumber, @NonNull INetworkFramework.RawNetworkCallback callback) {
        Call<ResponseBody> call = deliveryServiceV5.addDelivery(homeownerId, createRequestBody(jsonTrackingNumber));
        processCall(call, callback);
    }
}
