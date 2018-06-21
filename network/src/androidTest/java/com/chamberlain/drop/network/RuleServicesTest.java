/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network;

import android.support.test.runner.AndroidJUnit4;

import com.chamberlain.drop.network.framework.INetworkFramework;
import com.chamberlain.drop.network.framework.network.NetworkResponse;
import com.chamberlain.drop.network.mock.MockHelper;
import com.chamberlain.drop.network.mock.TestConstants;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class RuleServicesTest {

    private INetworkFramework networkFramework;
    private INetworkFramework mockedNetworkFramework;

    @Before
    public void setUp() {
        networkFramework = MockHelper.getInstance().getNetworkFramework();
        mockedNetworkFramework = MockHelper.getInstance().getMockedNetworkFramework();
    }

    @Test
    public void getAlertList_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        networkFramework.ruleService().getAlertList(TestConstants.ACCOUNT_ID, TestConstants.USER_ID, new INetworkFramework.RawNetworkCallback() {
            @Override
            public void onResponse(NetworkResponse response) {
                assertTrue(response.isSuccessful());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getScene_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        networkFramework.ruleService().getScene(TestConstants.ACCOUNT_ID, new INetworkFramework.RawNetworkCallback() {
            @Override
            public void onResponse(NetworkResponse response) {
                assertTrue(response.isSuccessful());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
