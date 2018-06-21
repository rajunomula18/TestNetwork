/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service;

import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework.RawNetworkCallback;
import com.chamberlain.drop.network.framework.network.retrofit.UserServiceV5;
import com.chamberlain.drop.network.framework.service.contract.IUserService;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class UserService extends BaseService implements IUserService {

    private UserServiceV5 userServiceV5;

    public UserService(UserServiceV5 userServiceV5) {
        this.userServiceV5 = userServiceV5;
    }

    @Override
    public void logUserIn(@NonNull String login, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.logUserIn(createRequestBody(login));
        processCall(call, callback);
    }

    @Override
    public void verifyUser(@NonNull String info, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.verifyUser(createRequestBody(info));
        processCall(call, callback);
    }

    @Override
    public void getTimezones(@NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.getTimezones();
        processCall(call, callback);
    }

    @Override
    public void getCountries(@NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.getCountries();
        processCall(call, callback);
    }

    @Override
    public void createUser(@NonNull String user, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.createUser(createRequestBody(user));
        processCall(call, callback);
    }

    @Override
    public void changeEmail(@NonNull String email, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.changeEmail(createRequestBody(email));
        processCall(call, callback);
    }

    @Override
    public void changePushEmail(@NonNull String email, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.changePushEmail(createRequestBody(email));
        processCall(call, callback);
    }

    @Override
    public void resetPassword(@NonNull String email, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.resetPassword(createRequestBody(email));
        processCall(call, callback);
    }

    @Override
    public void changePassword(@NonNull String password, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.changePassword(createRequestBody(password));
        processCall(call, callback);
    }

    @Override
    public void resendRegistrationConfirmation(@NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.resendRegistrationConfirmation(createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void getUserProfile(@NonNull Map<String, String> params, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.getUserProfile(params);
        processCall(call, callback);
    }

    @Override
    public void updateUserProfile(@NonNull String user, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.updateUserProfile(createRequestBody(user));
        processCall(call, callback);
    }

    //DeviceServices
    @Override
    public void registerSmartDevices(@NonNull String smartDeviceUUID, @NonNull String device, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.registerSmartDevices(smartDeviceUUID, createRequestBody(device));
        processCall(call, callback);
    }

    @Override
    public void deleteSmartDevices(@NonNull String smartDeviceId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.deleteSmartDevices(smartDeviceId);
        processCall(call, callback);
    }

    @Override
    public void getSmartDevicesTags(@NonNull String smartDeviceId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.getSmartDevicesTags(smartDeviceId);
        processCall(call, callback);
    }

    @Override
    public void getGDPRComplianceStatus(@NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.getGDPRComplianceStatus();
        processCall(call, callback);
    }

    @Override
    public void acceptGDPRToS(@NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.acceptGDPRToS();
        processCall(call, callback);
    }

    @Override
    public void updateGDPRPrivacyConsent(@NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.updateGDPRPrivacyConsent(createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void getRegionContent(@NonNull String name, @NonNull String brand, @NonNull String region, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = userServiceV5.getRegionContent(name, brand, region);
        processCall(call, callback);
    }
}
