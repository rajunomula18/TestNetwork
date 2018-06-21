/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network;

import android.os.Build;
import android.support.test.runner.AndroidJUnit4;

import com.chamberlain.drop.network.framework.ICredentialsProvider;
import com.chamberlain.drop.network.framework.INetworkFramework;
import com.chamberlain.drop.network.framework.network.NetworkResponse;
import com.chamberlain.drop.network.mock.MockHelper;
import com.chamberlain.drop.network.mock.TestConstants;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import static com.chamberlain.drop.network.mock.TestConstants.LOGIN;
import static com.chamberlain.drop.network.mock.TestConstants.PASSWORD;
import static org.junit.Assert.assertTrue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class UserServicesTest {
    private ICredentialsProvider mockCredentialsProvider;
    private INetworkFramework networkFramework;
    private INetworkFramework mockedNetworkFramework;

    @Before
    public void setUp() {
        networkFramework = MockHelper.getInstance().getNetworkFramework();
        mockedNetworkFramework = MockHelper.getInstance().getMockedNetworkFramework();
    }

    @Test
    public void validateUser_verifyResponseSecurityToken() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        JSONObject loginInfo = new JSONObject();
        try {
            loginInfo.put("username", LOGIN);
            loginInfo.put("password", PASSWORD);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mockedNetworkFramework.userService().logUserIn(loginInfo.toString(), new INetworkFramework.RawNetworkCallback() {
            @Override
            public void onResponse(NetworkResponse response) {
                assertTrue(response.isSuccessful());
                countDownLatch.countDown();
                 /*String securityToken = response.securityToken();
        assertFalse(securityToken.isEmpty());
        mockCredentialsProvider.onRefreshSecurityToken(securityToken);
        countDownLatch.countDown();*/
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
        assertTrue(true);
    }

    @Test
    public void getTimezones_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.userService().getTimezones(new INetworkFramework.RawNetworkCallback() {
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
    public void getCountries_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.userService().getCountries(new INetworkFramework.RawNetworkCallback() {
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
    public void getUserProfiles_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Map<String, String> params = new HashMap<>();
        params.put("expand", "account");
        mockedNetworkFramework.userService().getUserProfile(params, new INetworkFramework.RawNetworkCallback() {
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

    private String getUserProfileJSON() {
        long unixTime = System.currentTimeMillis() / 1000L;
        final String firstName = "Tester" + unixTime;
        final String lastName = "Tester" + unixTime;
        JSONObject jsonObject = new JSONObject();
        try {
            JSONObject address = new JSONObject();
            JSONObject timeZone = new JSONObject();
            JSONObject country = new JSONObject();
            country.put("Code", "USA");
            address.put("PostalCode", "60007");
            address.put("AddressLine1", "");
            address.put("AddressLine2", "");
            address.put("State", "");
            address.put("Country", country);

            timeZone.put("Id", "Europe/Minsk");

            jsonObject.put("UserName", LOGIN);
            jsonObject.put("Email", LOGIN);
            jsonObject.put("FirstName", firstName);
            jsonObject.put("LastName", lastName);

            jsonObject.put("Phone", "");
            jsonObject.put("Address", address);
            jsonObject.put("TimeZone", timeZone);
            jsonObject.put("CultureCode", "en");
            jsonObject.put("LastName", lastName);
            jsonObject.put("MailingListOptIn", true);
            jsonObject.put("RequestAccountLinkInfo", false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Test
    public void updateUserProfiles_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String userJSON = getUserProfileJSON();
        networkFramework.userService().updateUserProfile(userJSON, new INetworkFramework.RawNetworkCallback() {
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
    public void verifyUserMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        JSONObject params = new JSONObject();
        try {
            params.put("Email", TestConstants.LOGIN);
            params.put("RegistrationCode", "regCode");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mockedNetworkFramework.userService().verifyUser(params.toString(), new INetworkFramework.RawNetworkCallback() {
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
    public void createUserMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        JSONObject userJSON = new JSONObject();
        try {
            userJSON.put("UserName", TestConstants.LOGIN);
            userJSON.put("FirstName", TestConstants.ACCOUNT_NAME);
            userJSON.put("LastName", TestConstants.ACCOUNT_NAME);
            userJSON.put("Password", "password");
            userJSON.put("Email", TestConstants.LOGIN);
            userJSON.put("StreetPostalCode", "12345");
            userJSON.put("CountryCode", "USA");
            userJSON.put("TimeZoneId", "AST");
            userJSON.put("CultureCode", "en");
            userJSON.put("MailingListOptIn", true);
            userJSON.put("RequestAccountLinkInfo", 1);
            userJSON.put("BrandId", "brandId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mockedNetworkFramework.userService().createUser(userJSON.toString(), new INetworkFramework.RawNetworkCallback() {
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
    public void changeEmailMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.userService().changeEmail(TestConstants.LOGIN, new INetworkFramework.RawNetworkCallback() {
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
    public void changePushEmailMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.userService().changePushEmail(TestConstants.LOGIN, new INetworkFramework.RawNetworkCallback() {
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
    public void resetPasswordMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.userService().resetPassword(TestConstants.LOGIN, new INetworkFramework.RawNetworkCallback() {
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
    public void changePasswordMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.userService().changePassword("new_password", new INetworkFramework.RawNetworkCallback() {
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
    public void updateUserProfileMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String userJSON = getUserProfileJSON();
        mockedNetworkFramework.userService().updateUserProfile(userJSON, new INetworkFramework.RawNetworkCallback() {
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
    public void registerSmartDevicesMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String smartDeviceUUID = "smartDeviceUUID";
        JSONObject deviceJSONObject = new JSONObject();
        try {
            deviceJSONObject.put("model", Build.MODEL);
            deviceJSONObject.put("os_version", Build.VERSION.RELEASE);
            deviceJSONObject.put("platform", "Android");
            deviceJSONObject.put("app_version", BuildConfig.VERSION_NAME);
            deviceJSONObject.put("hub", "chamberlain");
            deviceJSONObject.put("device_token", "gcmToken");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mockedNetworkFramework.userService().registerSmartDevices(smartDeviceUUID, deviceJSONObject.toString(), new INetworkFramework.RawNetworkCallback() {
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
    public void deleteSmartDevicesMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String smartDeviceUUID = "smartDeviceUUID";
        mockedNetworkFramework.userService().deleteSmartDevices(smartDeviceUUID, new INetworkFramework.RawNetworkCallback() {
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
    public void getSmartDevicesTagsMocked_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String smartDeviceUUID = "smartDeviceUUID";
        mockedNetworkFramework.userService().getSmartDevicesTags(smartDeviceUUID, new INetworkFramework.RawNetworkCallback() {
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
