/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service.contract;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chamberlain.drop.network.framework.INetworkFramework.RawNetworkCallback;

import java.util.Map;

public interface IAccountService {

    void getAccounts(@Nullable String accountId, @NonNull Map<String, String> params, @NonNull RawNetworkCallback callback);

    void updateAccount(@NonNull String accountId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void getMyAccountUsers(@NonNull Map<String, String> params, @NonNull RawNetworkCallback callback);

    void createAccountUser(@NonNull String accountId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void inviteUser(@NonNull String accountId, @NonNull String userId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void deleteAccountUser(@NonNull String accountId, @NonNull String userId, @NonNull RawNetworkCallback callback);

    void getAccountUser(@NonNull String accountId, @NonNull Map<String, String> params, @NonNull RawNetworkCallback callback);

    void getAccountUserRoles(@NonNull String accountId, @NonNull String userId, @NonNull RawNetworkCallback callback);

    void completeAccountLinking(@NonNull String jsonBody, @NonNull RawNetworkCallback callback);

    void getInvitationStatus(@NonNull String invitationId, @NonNull RawNetworkCallback callback);

    void getMyInvitations(@NonNull RawNetworkCallback callback);

    void acceptMyInvitation(@NonNull String invitationId, @NonNull RawNetworkCallback callback);

    void denyMyInvitation(@NonNull String invitationId, @NonNull RawNetworkCallback callback);

    void getAccountRoles(@NonNull String accountId, @NonNull RawNetworkCallback callback);

    void updateAccountUserRoles(@NonNull String accountId, @NonNull String userId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback);
}
