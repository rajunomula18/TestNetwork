/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network.mock;

import com.chamberlain.drop.network.framework.ICredentialsProvider;
import com.chamberlain.drop.network.framework.INetworkFramework;

import static com.chamberlain.drop.network.mock.TestConstants.LOGIN;
import static com.chamberlain.drop.network.mock.TestConstants.PASSWORD;

public class MockCredentialsProvider implements ICredentialsProvider {

    private String mSecurityToken;
    private INetworkFramework mNetworkFramework;

    MockCredentialsProvider(String securityToken, INetworkFramework networkFramework) {
        mSecurityToken = securityToken;
        mNetworkFramework = networkFramework;
    }

    @Override
    public String getSecurityToken() {
        return mSecurityToken;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public String getUserName() {
        return LOGIN;
    }

    @Override
    public void onRefreshSecurityToken(String securityToken) {
        mSecurityToken = securityToken;
        mNetworkFramework.setCredentialsProvider(this);
    }
}
