/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network.mock;

import com.chamberlain.drop.network.framework.NetworkFramework;
import com.chamberlain.drop.network.framework.model.PhotoMultipartFormatter;
import com.chamberlain.drop.network.framework.network.retrofit.AccountServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.DeliveryServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.DeviceServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.EventServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.PartnerServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.ProvisioningServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.RuleServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.UserServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.VGDOServiceV5;
import com.chamberlain.drop.network.framework.service.AccountService;
import com.chamberlain.drop.network.framework.service.DeliveryService;
import com.chamberlain.drop.network.framework.service.DeviceService;
import com.chamberlain.drop.network.framework.service.EventService;
import com.chamberlain.drop.network.framework.service.PartnerService;
import com.chamberlain.drop.network.framework.service.ProvisioningService;
import com.chamberlain.drop.network.framework.service.RuleService;
import com.chamberlain.drop.network.framework.service.UserService;
import com.chamberlain.drop.network.framework.service.VGDOService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;

public class MockedNetworkFramework extends NetworkFramework {

    private MockWebServer mockWebServer;
    private Retrofit retrofit;

    public MockedNetworkFramework() {
        mockWebServer = new MockWebServer();
        mockWebServer.enqueue(new MockResponse()
                .setBody("your json body")
                .setResponseCode(200));
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("").toString())
                .client(okHttpClientBuilder.build())
                .build();

        this.accountService = new AccountService(retrofit.create(AccountServiceV5.class));
        this.deviceService = new DeviceService(retrofit.create(DeviceServiceV5.class));
        this.eventService = new EventService(retrofit.create(EventServiceV5.class));
        this.deliveryService = new DeliveryService(retrofit.create(DeliveryServiceV5.class), new PhotoMultipartFormatter("photo_image"));
        this.ruleService = new RuleService(retrofit.create(RuleServiceV5.class));
        this.userService = new UserService(retrofit.create(UserServiceV5.class));
        this.vgdoService = new VGDOService(retrofit.create(VGDOServiceV5.class));
        this.partnerService = new PartnerService(retrofit.create(PartnerServiceV5.class));
        this.provisioningService = new ProvisioningService(retrofit.create(ProvisioningServiceV5.class));
    }
}