/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service.contract;


import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework.RawNetworkCallback;

public interface IDeviceService {

    void getDeviceDetailsList(@NonNull String accountId, @NonNull RawNetworkCallback callback);

    void getDeviceDetails(@NonNull String accountId, @NonNull String serialNumber, @NonNull RawNetworkCallback callback);

    void registerGateway(@NonNull String accountId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void deviceAction(@NonNull String accountId, @NonNull String deviceId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void getMivCameraEvents(@NonNull String accountId, @NonNull String serialNumber, int pageNumber, int pageSize, @NonNull RawNetworkCallback callback);

    void getMivCameraLogin(@NonNull String accountId, @NonNull String serialNumber, @NonNull RawNetworkCallback callback);

    void removeDevice(@NonNull String accountId, @NonNull String deviceId, @NonNull RawNetworkCallback callback);

    void updateDeviceName(@NonNull String accountId, @NonNull String deviceId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void getDeviceKeys(@NonNull String accountId, @NonNull String serialNumber, @NonNull RawNetworkCallback callback);

    void registerIntellivisionCamera(@NonNull String accountId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);
}
