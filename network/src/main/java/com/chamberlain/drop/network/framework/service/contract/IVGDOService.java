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

public interface IVGDOService {

    void getAvailableVGDOs(@NonNull String accountId, @NonNull String deviceId, @NonNull RawNetworkCallback callback);

    void getSensorConnectionStatus(@NonNull String accountId, @NonNull String deviceId, @NonNull Map<String, String> params, @NonNull RawNetworkCallback callback);

    void startSensorLearnProcess(@NonNull String accountId, @NonNull String deviceId, @NonNull RawNetworkCallback callback);

    void getBrandQuestions(@NonNull Map<String, String> params, @NonNull RawNetworkCallback callback);

    void startLearningDoor(@NonNull String accountId, @NonNull String deviceId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void getWorkFlowStatus(@NonNull String accountId, @NonNull String deviceId, @NonNull RawNetworkCallback callback);

    void continueLearningDoor(@NonNull String accountId, @NonNull String deviceId, @NonNull RawNetworkCallback callback);

    void cancelLearningDoor(@NonNull String accountId, @NonNull String deviceId, @NonNull RawNetworkCallback callback);
}
