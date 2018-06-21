/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network.framework.di;


import com.chamberlain.drop.network.framework.INetworkFramework;
import com.chamberlain.drop.network.framework.NetworkFramework;
import com.chamberlain.drop.network.framework.TokenAuthenticatorHelper;
import com.chamberlain.drop.network.framework.model.PhotoMultipartFormatter;
import com.chamberlain.drop.network.framework.network.HeaderInterceptor;
import com.chamberlain.drop.network.framework.network.retrofit.AccountServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.DeliveryServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.DeviceServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.EventServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.PartnerServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.ProvisioningServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.RuleServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.UserServiceV5;
import com.chamberlain.drop.network.framework.network.retrofit.VGDOServiceV5;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ServicesModule {
    public static final String PHOTO_PART_NAME = "photo_image";

    private final String baseUrl;
    private final String deliveryUrl;
    private final String provisioningUrl;

    ServicesModule(String baseUrl, String deliveryUrl, String provisioningUrl) {
        this.baseUrl = baseUrl;
        this.deliveryUrl = deliveryUrl;
        this.provisioningUrl = provisioningUrl;
    }

    @Provides
    @Named(PHOTO_PART_NAME)
    String providePhotoPartName() {
        return PHOTO_PART_NAME;
    }

    @Provides
    @Singleton
    UserServiceV5 provideUserService(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder
                .baseUrl(baseUrl)
                .build()
                .create(UserServiceV5.class);
    }

    @Provides
    @Singleton
    DeviceServiceV5 provideDeviceService(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder
                .baseUrl(baseUrl)
                .build()
                .create(DeviceServiceV5.class);
    }

    @Provides
    @Singleton
    EventServiceV5 provideEventService(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder
                .baseUrl(baseUrl)
                .build()
                .create(EventServiceV5.class);
    }

    @Provides
    @Singleton
    RuleServiceV5 provideRuleService(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder
                .baseUrl(baseUrl)
                .build()
                .create(RuleServiceV5.class);
    }

    @Provides
    @Singleton
    VGDOServiceV5 provideVGDOService(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder
                .baseUrl(baseUrl)
                .build()
                .create(VGDOServiceV5.class);
    }

    @Provides
    @Singleton
    AccountServiceV5 provideAccountService(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder
                .baseUrl(baseUrl)
                .build()
                .create(AccountServiceV5.class);
    }

    @Provides
    @Singleton
    DeliveryServiceV5 provideDeliveryService(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder
                .baseUrl(deliveryUrl)
                .build()
                .create(DeliveryServiceV5.class);
    }

    @Provides
    @Singleton
    PartnerServiceV5 providePartnerService(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder
                .baseUrl(baseUrl)
                .build()
                .create(PartnerServiceV5.class);
    }

    @Provides
    @Singleton
    ProvisioningServiceV5 provideProvisioningService(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder
                .baseUrl(provisioningUrl)
                .build()
                .create(ProvisioningServiceV5.class);
    }

    @Provides
    @Singleton
    INetworkFramework provideMyQNetworkServices(UserServiceV5 userServiceV5,
                                                DeviceServiceV5 deviceServiceV5,
                                                EventServiceV5 eventServicesV5,
                                                RuleServiceV5 ruleServiceV5,
                                                VGDOServiceV5 vgdoServiceV5,
                                                AccountServiceV5 accountServiceV5,
                                                DeliveryServiceV5 deliveryService,
                                                PartnerServiceV5 partnerServiceV5,
                                                ProvisioningServiceV5 provisioningServiceV5,
                                                HeaderInterceptor headerInterceptor,
                                                TokenAuthenticatorHelper tokenAuthenticatorHelper,
                                                PhotoMultipartFormatter photoMultipartFormatter) {
        return new NetworkFramework(
                userServiceV5,
                deviceServiceV5,
                eventServicesV5,
                ruleServiceV5,
                vgdoServiceV5,
                accountServiceV5,
                deliveryService,
                partnerServiceV5,
                provisioningServiceV5,
                headerInterceptor,
                tokenAuthenticatorHelper,
                photoMultipartFormatter);
    }
}
