/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service.contract;

import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework.RawNetworkCallback;

import java.util.Map;

public interface IUserService {

    void logUserIn(@NonNull String login, @NonNull final RawNetworkCallback callback);

    void verifyUser(@NonNull String info, @NonNull final RawNetworkCallback callback);

    void getTimezones(@NonNull final RawNetworkCallback callback);

    void getCountries(@NonNull final RawNetworkCallback callback);

    void createUser(@NonNull String user, @NonNull final RawNetworkCallback callback);

    void changeEmail(@NonNull String email, @NonNull final RawNetworkCallback callback);

    void changePushEmail(@NonNull String email, @NonNull final RawNetworkCallback callback);

    void resetPassword(@NonNull String email, @NonNull final RawNetworkCallback callback);

    void changePassword(@NonNull String password, @NonNull final RawNetworkCallback callback);

    void resendRegistrationConfirmation(@NonNull String jsonBody, @NonNull final RawNetworkCallback callback);

    void getUserProfile(@NonNull Map<String, String> params, @NonNull final RawNetworkCallback callback);

    void updateUserProfile(@NonNull String user, @NonNull final RawNetworkCallback callback);

    void registerSmartDevices(@NonNull String smartDeviceUUID, @NonNull String device, @NonNull final RawNetworkCallback callback);

    void deleteSmartDevices(@NonNull String smartDeviceId, @NonNull final RawNetworkCallback callback);

    void getSmartDevicesTags(@NonNull String smartDeviceId, @NonNull final RawNetworkCallback callback);

    void getGDPRComplianceStatus(@NonNull final RawNetworkCallback callback);

    void acceptGDPRToS(@NonNull final RawNetworkCallback callback);

    void updateGDPRPrivacyConsent(@NonNull String jsonBody, @NonNull final RawNetworkCallback callback);

    void getRegionContent(@NonNull String name, @NonNull String brand, @NonNull String region, @NonNull final RawNetworkCallback callback);
}
