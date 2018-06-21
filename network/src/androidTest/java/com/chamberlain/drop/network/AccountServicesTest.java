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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import static com.chamberlain.drop.network.mock.TestConstants.ACCOUNT_ID;
import static com.chamberlain.drop.network.mock.TestConstants.ACCOUNT_NAME;
import static com.chamberlain.drop.network.mock.TestConstants.INVITE_USER_ID;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class AccountServicesTest {
    private static final String PARAM_INCLUDE_INACTIVE = "IncluceInactive";
    private static final String PARAM_EXPAND = "expand";
    private static final String PARAM_ROLES = "roles";
    private static final String PARAM_INVITATION = "invitation";

    private INetworkFramework networkFramework;
    private INetworkFramework mockedNetworkFramework;

    @Before
    public void setUp() {
        networkFramework = MockHelper.getInstance().getNetworkFramework();
        mockedNetworkFramework = MockHelper.getInstance().getMockedNetworkFramework();
    }

    @Test
    public void makeCallToGetAccounts_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Map<String, String> params = new HashMap<>();
        params.put(PARAM_EXPAND, PARAM_ROLES);
        mockedNetworkFramework.accountService().getAccounts(null, params, new INetworkFramework.RawNetworkCallback() {
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
    public void makeCallToUpdateAccount_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        JSONObject params = new JSONObject();
        try {
            params.put("Name", ACCOUNT_NAME);
            mockedNetworkFramework.accountService().updateAccount(ACCOUNT_ID, params.toString(), new INetworkFramework.RawNetworkCallback() {
                @Override
                public void onResponse(NetworkResponse response) {
                    assertTrue(response.isSuccessful());
                    countDownLatch.countDown();
                }

                @Override
                public void onFailure(Throwable t) {
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void makeCallToGetMyAccountUsers_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Map<String, String> params = new HashMap<>();
        params.put(PARAM_EXPAND, PARAM_ROLES);
        mockedNetworkFramework.accountService().getMyAccountUsers(params, new INetworkFramework.RawNetworkCallback() {
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
    public void makeMockedCallToCreateAccountUser_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            JSONObject params = new JSONObject();
            params.put("Email", "");
            JSONArray rolesArray = new JSONArray();
            rolesArray.put("");
            params.put("AccountRoles", rolesArray);
            mockedNetworkFramework.accountService().createAccountUser(ACCOUNT_ID, params.toString(), new INetworkFramework.RawNetworkCallback() {
                @Override
                public void onResponse(NetworkResponse response) {
                    assertTrue(response.isSuccessful());
                    countDownLatch.countDown();
                }

                @Override
                public void onFailure(Throwable t) {
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void makeMockedCallToInviteUser_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            JSONObject params = new JSONObject();
            params.put("Email", "");
            mockedNetworkFramework.accountService().inviteUser(ACCOUNT_ID, INVITE_USER_ID, params.toString(), new INetworkFramework.RawNetworkCallback() {
                @Override
                public void onResponse(NetworkResponse response) {
                    assertTrue(response.isSuccessful());
                    countDownLatch.countDown();
                }

                @Override
                public void onFailure(Throwable t) {
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void makeMockedCallToDeleteUser_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.accountService().deleteAccountUser(ACCOUNT_ID, INVITE_USER_ID, new INetworkFramework.RawNetworkCallback() {
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
    public void makeCallToGetAccountUser_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Map<String, String> params = new HashMap<>();
        params.put(PARAM_INCLUDE_INACTIVE, "true");
        params.put(PARAM_EXPAND, PARAM_ROLES + "," + PARAM_INVITATION);
        mockedNetworkFramework.accountService().getAccountUser(ACCOUNT_ID, params, new INetworkFramework.RawNetworkCallback() {
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
    public void makeCallToGetAccountUserRoles_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.accountService().getAccountUserRoles(ACCOUNT_ID, INVITE_USER_ID, new INetworkFramework.RawNetworkCallback() {
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
    public void makeMockedCallToCompleteAccountLinking_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.accountService().completeAccountLinking("", new INetworkFramework.RawNetworkCallback() {
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
    public void makeMockedCallToGetInvitationStatus_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.accountService().getInvitationStatus("", new INetworkFramework.RawNetworkCallback() {
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
    public void makeMockedCallToAcceptMyInvitation_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.accountService().acceptMyInvitation("", new INetworkFramework.RawNetworkCallback() {
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
    public void makeMockedCallToDenyMyInvitation_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.accountService().denyMyInvitation("", new INetworkFramework.RawNetworkCallback() {
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
    public void makeCallToGetMyInvitations_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.accountService().getMyInvitations(new INetworkFramework.RawNetworkCallback() {
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
    public void makeCallToGetAccountRoles_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.accountService().getAccountRoles(ACCOUNT_ID, new INetworkFramework.RawNetworkCallback() {
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
    public void makeMockedCallToUpdateAccountUserRoles_verifyResponseSuccess() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mockedNetworkFramework.accountService().updateAccountUserRoles("", "", "", new INetworkFramework.RawNetworkCallback() {
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
