/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chamberlain.drop.network.framework.INetworkFramework.RawNetworkCallback;
import com.chamberlain.drop.network.framework.network.retrofit.AccountServiceV5;
import com.chamberlain.drop.network.framework.service.contract.IAccountService;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class AccountService extends BaseService implements IAccountService {

    private AccountServiceV5 accountServiceV5;

    public AccountService(AccountServiceV5 accountServiceV5) {
        this.accountServiceV5 = accountServiceV5;
    }

    @Override
    public void getAccounts(@Nullable String accountId, @NonNull Map<String, String> params, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountId == null ? accountServiceV5.getAccounts(params) : accountServiceV5.getAccounts(accountId, params);
        processCall(call, callback);
    }

    @Override
    public void updateAccount(@NonNull String accountId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.updateAccount(accountId, createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void getMyAccountUsers(@NonNull Map<String, String> params, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.getMyAccountUsers(params);
        processCall(call, callback);
    }

    @Override
    public void createAccountUser(@NonNull String accountId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.createAccountUser(accountId, createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void inviteUser(@NonNull String accountId, @NonNull String userId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.inviteUser(accountId, userId, createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void deleteAccountUser(@NonNull String accountId, @NonNull String userId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.deleteAccountUser(accountId, userId);
        processCall(call, callback);
    }

    @Override
    public void getAccountUser(@NonNull String accountId, @NonNull Map<String, String> params, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.getAccountUser(accountId, params);
        processCall(call, callback);
    }

    @Override
    public void getAccountUserRoles(@NonNull String accountId, @NonNull String userId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.getAccountUserRoles(accountId, userId);
        processCall(call, callback);
    }

    @Override
    public void completeAccountLinking(@NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.completeAccountLinking(createRequestBody(jsonBody));
        processCall(call, callback);
    }

    @Override
    public void getInvitationStatus(@NonNull String invitationId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.getInvitationStatus(invitationId);
        processCall(call, callback);
    }

    @Override
    public void getMyInvitations(@NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.getMyInvitations();
        processCall(call, callback);
    }

    @Override
    public void acceptMyInvitation(@NonNull String invitationId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.acceptMyInvitation(invitationId);
        processCall(call, callback);
    }

    @Override
    public void denyMyInvitation(@NonNull String invitationId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.denyMyInvitation(invitationId);
        processCall(call, callback);
    }

    @Override
    public void getAccountRoles(@NonNull String accountId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.getAccountRoles(accountId);
        processCall(call, callback);
    }

    @Override
    public void updateAccountUserRoles(@NonNull String accountId, @NonNull String userId, @NonNull String jsonBody, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = accountServiceV5.updateAccountUserRoles(accountId, userId, createRequestBody(jsonBody));
        processCall(call, callback);
    }
}
