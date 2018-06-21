/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.service;

import android.support.annotation.NonNull;

import com.chamberlain.drop.network.framework.INetworkFramework.RawNetworkCallback;
import com.chamberlain.drop.network.framework.network.retrofit.EventServiceV5;
import com.chamberlain.drop.network.framework.service.contract.IEventService;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class EventService extends BaseService implements IEventService {

    private EventServiceV5 eventServicesV5;

    public EventService(EventServiceV5 eventServicesV5) {
        this.eventServicesV5 = eventServicesV5;
    }

    @Override
    public void getEventHistory(@NonNull String accountId, @NonNull Map<String, String> params, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = eventServicesV5.getEventHistory(accountId, params);
        processCall(call, callback);
    }

    @Override
    public void getEventHistory(@NonNull String accountId, @NonNull String eventId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = eventServicesV5.getEventHistory(accountId, eventId);
        processCall(call, callback);
    }

    @Override
    public void getDropEventHistory(@NonNull String accountId, @NonNull String eventId, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = eventServicesV5.getDropEventHistory(accountId, eventId);
        processCall(call, callback);
    }

    @Override
    public void deleteEventHistory(@NonNull String accountId, @NonNull Map<String, String> params, @NonNull RawNetworkCallback callback) {
        Call<ResponseBody> call = eventServicesV5.deleteEventHistory(accountId, params);
        processCall(call, callback);
    }
}
