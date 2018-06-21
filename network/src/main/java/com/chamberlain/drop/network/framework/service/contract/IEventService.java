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

public interface IEventService {

    void getEventHistory(@NonNull String accountId, @NonNull Map<String, String> params, @NonNull RawNetworkCallback callback);

    void getEventHistory(@NonNull String accountId, @NonNull String eventId, @NonNull RawNetworkCallback callback);

    void getDropEventHistory(@NonNull String accountId, @NonNull String eventId, @NonNull RawNetworkCallback callback);

    void deleteEventHistory(@NonNull String accountId, @NonNull Map<String, String> params, @NonNull RawNetworkCallback callback);
}
