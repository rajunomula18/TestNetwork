/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network.framework;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chamberlain.drop.network.framework.di.DaggerWrapper;
import com.chamberlain.drop.network.framework.network.NetworkResponse;
import com.chamberlain.drop.network.framework.service.contract.IAccountService;
import com.chamberlain.drop.network.framework.service.contract.IDeliveryService;
import com.chamberlain.drop.network.framework.service.contract.IDeviceService;
import com.chamberlain.drop.network.framework.service.contract.IEventService;
import com.chamberlain.drop.network.framework.service.contract.IPartnerService;
import com.chamberlain.drop.network.framework.service.contract.IProvisioningService;
import com.chamberlain.drop.network.framework.service.contract.IRuleService;
import com.chamberlain.drop.network.framework.service.contract.IUserService;
import com.chamberlain.drop.network.framework.service.contract.IVGDOService;

/**
 * This is the list of possible remote calls to the server.
 */
public interface INetworkFramework {

    static INetworkFramework getInstance(@NonNull String applicationId,
                                         @Nullable String securityToken,
                                         @NonNull String baseUrl,
                                         @Nullable String deliveryUrl,
                                         @Nullable String provisioningUrl,
                                         boolean enableDebugLogging) {
        return DaggerWrapper.getComponent(
                applicationId,
                securityToken,
                baseUrl,
                TextUtils.isEmpty(deliveryUrl) ? baseUrl : deliveryUrl,
                TextUtils.isEmpty(provisioningUrl) ? baseUrl : provisioningUrl,
                enableDebugLogging)
                .networkFramework();
    }

    static INetworkFramework resetInstance(String applicationId,
                              String securityToken,
                              @NonNull String baseUrl,
                              @NonNull String deliveryUrl,
                              @NonNull String provisioningUrl,
                              boolean enableDebugLogging){
        return DaggerWrapper.resetFrameworkComponent(applicationId,
                securityToken,
                baseUrl,
                deliveryUrl,
                provisioningUrl,
                enableDebugLogging).networkFramework();
    }

    IAccountService accountService();

    IDeviceService deviceService();

    IEventService eventService();

    IDeliveryService deliveryService();

    IRuleService ruleService();

    IUserService userService();

    IVGDOService vgdoService();

    IPartnerService partnerService();

    IProvisioningService provisioningService();

    void setSecurityToken(@Nullable String securityToken);

    void setCredentialsProvider(@NonNull ICredentialsProvider credentialsProvider);

    ICredentialsProvider getCredentialsProvider();

    interface RawNetworkCallback {
        void onResponse(@NonNull NetworkResponse response);

        void onFailure(@NonNull Throwable t);
    }
}
