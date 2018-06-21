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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import static com.chamberlain.drop.network.mock.TestConstants.ACCOUNT_ID;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class EventServiceTest {
    private static final String PARAM_PAGE_NUMBER = "pageNumber";
    private static final String PARAM_PAGE_SIZE = "pageSize";
    private static final String PARAM_FILTER = "filter";
    private static final String EVENT_FILTER = "myqdevices,scenes,nestdevices,cameras";

    private INetworkFramework networkFramework;
    private INetworkFramework mockedNetworkFramework;

    @Before
    public void setUp() {
        networkFramework = MockHelper.getInstance().getNetworkFramework();
        mockedNetworkFramework = MockHelper.getInstance().getMockedNetworkFramework();
    }

    @Test
    public void makeCallToGetEventHistory_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Map<String, String> params = new HashMap<>();
        params.put(PARAM_PAGE_NUMBER, String.valueOf(1));
        params.put(PARAM_PAGE_SIZE, String.valueOf(100));
        params.put(PARAM_FILTER, EVENT_FILTER);
        mockedNetworkFramework.eventService().getEventHistory(ACCOUNT_ID, params, new INetworkFramework.RawNetworkCallback() {
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
    public void makeMockedCallToDeleteEventHistory_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Map<String, String> params = new HashMap<>();
        params.put(PARAM_FILTER, EVENT_FILTER);
        mockedNetworkFramework.eventService().deleteEventHistory(ACCOUNT_ID, params, new INetworkFramework.RawNetworkCallback() {
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
