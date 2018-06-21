/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service.contract;

import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework.RawNetworkCallback;

import java.io.File;

public interface IDeliveryService {

    void getAllDeliveries(@NonNull String deliveryAssociateId, @NonNull RawNetworkCallback callback);

    void getHomeownersDeliveries(@NonNull String homeownerId, @NonNull RawNetworkCallback callback);

    void getDeliveryById(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull RawNetworkCallback callback);

    void updateDeliveryStatus(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull String deliveryStatus,
                              @NonNull RawNetworkCallback callback);

    void getDeliveryDeviceDetails(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull String deviceSerialNumber,
                                  @NonNull RawNetworkCallback callback);

    void triggerDeviceState(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull String deviceSerialNumber,
                            @NonNull String action, @NonNull RawNetworkCallback callback);

    void getHomeownerAccount(@NonNull RawNetworkCallback callback);

    void saveHomeownerDeliveryAddress(@NonNull String address, @NonNull RawNetworkCallback callback);

    void getRetailPartners(@NonNull String homeownerId, @NonNull RawNetworkCallback callback);

    void uploadPhoto(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull File photo, @NonNull RawNetworkCallback callback);

    void registerFcmToken(@NonNull String deliveryAssociateId, @NonNull String deviceId, @NonNull String fcmToken, @NonNull RawNetworkCallback callback);

    void unregisterFcmToken(@NonNull String deliveryAssociateId, @NonNull String deviceId, @NonNull RawNetworkCallback callback);

    void uploadFeedback(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull String feedback, @NonNull RawNetworkCallback callback);

    void getHomeOwnerAddresses(@NonNull String homeownerId, @NonNull RawNetworkCallback callback);

    void validateHomeownerAddress(@NonNull String homeownerAddressBody, @NonNull RawNetworkCallback callback);

    void createHomeownerAccount(@NonNull String address, @NonNull RawNetworkCallback callback);

    void registerHomeOwnerFcmToken(@NonNull String homeownerId, @NonNull String deviceId, @NonNull String fcmToken, @NonNull RawNetworkCallback callback);

    void unregisterHomeOwnerFcmToken(@NonNull String homeOwnerId, @NonNull String deviceId, @NonNull RawNetworkCallback callback);

    void triggerDeviceAction(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull String deviceSerialNumber,
                             @NonNull String actionBody, @NonNull RawNetworkCallback callback);

    void verifyLocation(@NonNull String deliveryId, @NonNull String deliveryAssociateId, @NonNull String verifyLocationBody,
                        @NonNull RawNetworkCallback callback);

    void getLoggedInUser(@NonNull RawNetworkCallback callback);

    void createUser(@NonNull String jsonUser, @NonNull RawNetworkCallback callback);

    void getAddressDevices(@NonNull String homeownerId, @NonNull String homeownerAddressId, @NonNull RawNetworkCallback callback);

    void addDelivery(@NonNull String homeownerId, @NonNull String jsonTrackingNumber, @NonNull RawNetworkCallback callback);
}
