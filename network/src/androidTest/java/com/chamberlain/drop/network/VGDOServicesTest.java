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
import static com.chamberlain.drop.network.mock.TestConstants.VGDO_DEVICE_ID;
import static com.chamberlain.drop.network.mock.TestConstants.VGDO_GATEWAY_ID;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class VGDOServicesTest {
    private INetworkFramework networkFramework;
    private INetworkFramework mockedNetworkFramework;

    @Before
    public void setUp() {
        networkFramework = MockHelper.getInstance().getNetworkFramework();
        mockedNetworkFramework = MockHelper.getInstance().getMockedNetworkFramework();
    }

    @Test
    public void makeCallToGetAvailableVGDOs_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        networkFramework.vgdoService().getAvailableVGDOs(ACCOUNT_ID, VGDO_GATEWAY_ID, new INetworkFramework.RawNetworkCallback() {
            @Override
            public void onResponse(NetworkResponse response) {
                assertTrue(response.isSuccessful());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Throwable t) {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void makeCallToGetSensorConnectionStatus_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Map<String, String> params = new HashMap<>();
        params.put("isLearnMode", "false");
        networkFramework.vgdoService().getSensorConnectionStatus(ACCOUNT_ID, VGDO_DEVICE_ID, params, new INetworkFramework.RawNetworkCallback() {
            @Override
            public void onResponse(NetworkResponse response) {
                assertTrue(response.isSuccessful());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Throwable t) {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void makeCallToGetBrandQuestions_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Map<String, String> params = new HashMap<>();
        networkFramework.vgdoService().getBrandQuestions(params, new INetworkFramework.RawNetworkCallback() {
            @Override
            public void onResponse(NetworkResponse response) {
                assertTrue(response.isSuccessful());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Throwable t) {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void makeCallToGetWorkFlowStatus_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        networkFramework.vgdoService().getWorkFlowStatus(ACCOUNT_ID, VGDO_DEVICE_ID, new INetworkFramework.RawNetworkCallback() {
            @Override
            public void onResponse(NetworkResponse response) {
                assertTrue(response.isSuccessful());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Throwable t) {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void makeCallToStartSensorLearnProcess_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.vgdoService().startSensorLearnProcess(ACCOUNT_ID, VGDO_DEVICE_ID, new INetworkFramework.RawNetworkCallback() {
            @Override
            public void onResponse(NetworkResponse response) {
                assertTrue(response.isSuccessful());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Throwable t) {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void makeMockedCallToStartLearningDoor_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.vgdoService().startLearningDoor(ACCOUNT_ID, VGDO_DEVICE_ID, "", new INetworkFramework.RawNetworkCallback() {
            @Override
            public void onResponse(NetworkResponse response) {
                assertTrue(response.isSuccessful());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Throwable t) {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void makeMockedCallToContinueLearningDoor_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.vgdoService().continueLearningDoor(ACCOUNT_ID, VGDO_DEVICE_ID, new INetworkFramework.RawNetworkCallback() {
            @Override
            public void onResponse(NetworkResponse response) {
                assertTrue(response.isSuccessful());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Throwable t) {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void makeMockedCallToCancelLearningDoor_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.vgdoService().cancelLearningDoor(ACCOUNT_ID, VGDO_DEVICE_ID, new INetworkFramework.RawNetworkCallback() {
            @Override
            public void onResponse(NetworkResponse response) {
                assertTrue(response.isSuccessful());
                countDownLatch.countDown();
            }

            @Override
            public void onFailure(Throwable t) {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
