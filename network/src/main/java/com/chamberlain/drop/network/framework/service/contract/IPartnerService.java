/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service.contract;

import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework;

import java.util.Map;

public interface IPartnerService {
    void getPartnerList(@NonNull Map<String, String> params, @NonNull  INetworkFramework.RawNetworkCallback callback);

    void linkPartner(@NonNull String partnerId, @NonNull  INetworkFramework.RawNetworkCallback callback);

    void unlinkPartner(@NonNull String partnerId, @NonNull  INetworkFramework.RawNetworkCallback callback);
}
