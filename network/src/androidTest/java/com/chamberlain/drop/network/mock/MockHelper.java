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

import static com.chamberlain.drop.network.mock.TestConstants.BASE_TEST_URL;
import static com.chamberlain.drop.network.mock.TestConstants.CHAMBERLAIN_APP_ID;

public class MockHelper {
    private static MockHelper INSTANCE;
    private INetworkFramework networkFramework;
    private INetworkFramework mockedNetworkFramework;
    private ICredentialsProvider mockCredentialsProvider;

    public static MockHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MockHelper();
        }
        return INSTANCE;
    }

    private MockHelper() {
        networkFramework = INetworkFramework.getInstance(
                CHAMBERLAIN_APP_ID,
                "",
                BASE_TEST_URL,
                BASE_TEST_URL,
                BASE_TEST_URL,
                true);
        mockCredentialsProvider = new MockCredentialsProvider("", networkFramework);
        networkFramework.setCredentialsProvider(mockCredentialsProvider);
        mockedNetworkFramework = new MockedNetworkFramework();
    }

    public INetworkFramework getNetworkFramework() {
        return networkFramework;
    }

    public INetworkFramework getMockedNetworkFramework() {
        return new MockedNetworkFramework();
    }

    public ICredentialsProvider getMockCredentialsProvider() {
        return mockCredentialsProvider;
    }
}
