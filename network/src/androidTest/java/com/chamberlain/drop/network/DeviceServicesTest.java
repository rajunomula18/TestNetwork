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

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DeviceServicesTest {

    private INetworkFramework networkFramework;
    private INetworkFramework mockedNetworkFramework;

    @Before
    public void setUp() {
        networkFramework = MockHelper.getInstance().getNetworkFramework();
        mockedNetworkFramework = MockHelper.getInstance().getMockedNetworkFramework();
    }

    @Test
    public void getDeviceDetailsList_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.deviceService().getDeviceDetailsList(TestConstants.ACCOUNT_ID, new INetworkFramework.RawNetworkCallback() {
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
    public void turnOnLamp_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("action_type", "turnon");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mockedNetworkFramework.deviceService().deviceAction(TestConstants.ACCOUNT_ID, TestConstants.LAMP_DEVICE_ID, jsonObject.toString(), new INetworkFramework.RawNetworkCallback() {
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
    public void openGarageDoor_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("action_type", "open");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mockedNetworkFramework.deviceService().deviceAction(TestConstants.ACCOUNT_ID, TestConstants.GARAGE_DOOR_DEVICE_ID, jsonObject.toString(), new INetworkFramework.RawNetworkCallback() {
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
    public void updateGarageDoorName_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        JSONObject jsonObject = new JSONObject();
        String newGDOName = "gdo1_" + (System.currentTimeMillis() / 1000L);
        try {
            jsonObject.put("name", newGDOName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mockedNetworkFramework.deviceService().updateDeviceName(TestConstants.ACCOUNT_ID, TestConstants.GARAGE_DOOR_DEVICE_ID, jsonObject.toString(), new INetworkFramework.RawNetworkCallback() {
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
    public void registerGateway_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("serial_number", TestConstants.GATEWAY_SERIAL_NUMBER);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mockedNetworkFramework.deviceService().registerGateway(TestConstants.ACCOUNT_ID, jsonObject.toString(), new INetworkFramework.RawNetworkCallback() {
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
    public void registerIntellivisionCameraMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.deviceService().registerIntellivisionCamera(TestConstants.ACCOUNT_ID, "", new INetworkFramework.RawNetworkCallback() {
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
    public void getMockedDeviceKeys_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.deviceService().getDeviceKeys(TestConstants.ACCOUNT_ID, "", new INetworkFramework.RawNetworkCallback() {
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
    public void getMivCameraEventsMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.deviceService().getMivCameraEvents(TestConstants.ACCOUNT_ID, "", 0, 0, new INetworkFramework.RawNetworkCallback() {
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
    public void getMivCameraLoginMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.deviceService().getMivCameraLogin(TestConstants.ACCOUNT_ID, "", new INetworkFramework.RawNetworkCallback() {
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
    public void removeDeviceMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.deviceService().removeDevice(TestConstants.ACCOUNT_ID, "", new INetworkFramework.RawNetworkCallback() {
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
