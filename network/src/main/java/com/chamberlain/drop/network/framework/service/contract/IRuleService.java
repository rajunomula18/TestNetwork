/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service.contract;

import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework.RawNetworkCallback;

public interface IRuleService {

    void getAlertList(@NonNull String accountId, @NonNull String userId, @NonNull RawNetworkCallback callback);

    void createAlert(@NonNull String accountId, @NonNull String userId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void updateAlert(@NonNull String accountId, @NonNull String userId, @NonNull String alertNotificationId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void deleteAlert(@NonNull String accountId, @NonNull String userId, @NonNull String alertNotificationId, @NonNull RawNetworkCallback callback);

    void testAlert(@NonNull String accountId, @NonNull String userId, @NonNull String alertNotificationId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void getScene(@NonNull String accountId, @NonNull RawNetworkCallback callback);

    void createScene(@NonNull String accountId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void updateScene(@NonNull String accountId, @NonNull String scheduleId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void deleteScene(@NonNull String accountId, @NonNull String scheduleId, @NonNull RawNetworkCallback callback);
}
