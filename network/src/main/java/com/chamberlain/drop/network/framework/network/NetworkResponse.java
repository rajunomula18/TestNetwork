/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework.network;

import android.support.annotation.Nullable;

import java.util.List;
import java.util.Map;

public class NetworkResponse {
    @Nullable
    private String responseBody;
    @Nullable
    private String errorBody;
    private int code;
    private String message;
    private Map<String, List<String>> headers;

    public NetworkResponse(@Nullable String responseBody, @Nullable String errorBody, int code, String message, Map<String, List<String>> headers) {
        this.responseBody = responseBody;
        this.errorBody = errorBody;
        this.code = code;
        this.message = message;
        this.headers = headers;
    }

    public boolean isSuccessful() {
        return code >= 200 && code < 300;
    }

    public String body() {
        return responseBody;
    }

    public String errorBody() {
        return errorBody;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

    public Map<String, List<String>> headers() {
        return headers;
    }
}
