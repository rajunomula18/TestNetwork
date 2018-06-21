/*
 * (c) 2018. Chamberlain Group, Inc. All rights reserved. All
 * information within this file and associated files, including all information
 * and files transferred with this file are CONFIDENTIAL and the proprietary
 * property of The Chamberlain Group, Inc.
 */

package com.chamberlain.drop.network.framework;

import android.support.annotation.NonNull;

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
import com.chamberlain.drop.network.framework.service.AccountService;
import com.chamberlain.drop.network.framework.service.DeliveryService;
import com.chamberlain.drop.network.framework.service.DeviceService;
import com.chamberlain.drop.network.framework.service.EventService;
import com.chamberlain.drop.network.framework.service.PartnerService;
import com.chamberlain.drop.network.framework.service.ProvisioningService;
import com.chamberlain.drop.network.framework.service.RuleService;
import com.chamberlain.drop.network.framework.service.UserService;
import com.chamberlain.drop.network.framework.service.VGDOService;
import com.chamberlain.drop.network.framework.service.contract.IAccountService;
import com.chamberlain.drop.network.framework.service.contract.IDeliveryService;
import com.chamberlain.drop.network.framework.service.contract.IDeviceService;
import com.chamberlain.drop.network.framework.service.contract.IEventService;
import com.chamberlain.drop.network.framework.service.contract.IPartnerService;
import com.chamberlain.drop.network.framework.service.contract.IProvisioningService;
import com.chamberlain.drop.network.framework.service.contract.IRuleService;
import com.chamberlain.drop.network.framework.service.contract.IUserService;
import com.chamberlain.drop.network.framework.service.contract.IVGDOService;

public class NetworkFramework implements INetworkFramework {

    private HeaderInterceptor headerInterceptor;
    private ICredentialsProvider credentialsProvider = null;
    private TokenAuthenticatorHelper tokenAuthenticatorHelper;

    protected AccountService accountService;
    protected DeviceService deviceService;
    protected EventService eventService;
    protected DeliveryService deliveryService;
    protected RuleService ruleService;
    protected UserService userService;
    protected VGDOService vgdoService;
    protected PartnerService partnerService;
    protected ProvisioningService provisioningService;

    public NetworkFramework(UserServiceV5 userServiceV5,
                            DeviceServiceV5 deviceServiceV5,
                            EventServiceV5 eventServicesV5,
                            RuleServiceV5 ruleServiceV5,
                            VGDOServiceV5 vgdoServiceV5,
                            AccountServiceV5 accountServiceV5,
                            DeliveryServiceV5 deliveryServiceV5,
                            PartnerServiceV5 partnerServiceV5,
                            ProvisioningServiceV5 provisioningServiceV5,
                            HeaderInterceptor headerInterceptor,
                            TokenAuthenticatorHelper tokenAuthenticatorHelper,
                            PhotoMultipartFormatter photoMultipartFormatter) {

        this.headerInterceptor = headerInterceptor;
        this.tokenAuthenticatorHelper = tokenAuthenticatorHelper;
        this.tokenAuthenticatorHelper.setNetworkFramework(this);
        this.accountService = new AccountService(accountServiceV5);
        this.deviceService = new DeviceService(deviceServiceV5);
        this.eventService = new EventService(eventServicesV5);
        this.deliveryService = new DeliveryService(deliveryServiceV5, photoMultipartFormatter);
        this.ruleService = new RuleService(ruleServiceV5);
        this.userService = new UserService(userServiceV5);
        this.vgdoService = new VGDOService(vgdoServiceV5);
        this.partnerService = new PartnerService(partnerServiceV5);
        this.provisioningService = new ProvisioningService(provisioningServiceV5);
    }

    public NetworkFramework() {
    }

    @Override
    public void setCredentialsProvider(@NonNull ICredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
        headerInterceptor.setSecurityToken(credentialsProvider.getSecurityToken());
    }

    @Override
    public ICredentialsProvider getCredentialsProvider() {
        return credentialsProvider;
    }

    @Override
    public void setSecurityToken(String securityToken) {
        headerInterceptor.setSecurityToken(securityToken);
    }

    @Override
    public IAccountService accountService() {
        return accountService;
    }

    @Override
    public IDeviceService deviceService() {
        return deviceService;
    }

    @Override
    public IEventService eventService() {
        return eventService;
    }

    @Override
    public IDeliveryService deliveryService() {
        return deliveryService;
    }

    @Override
    public IRuleService ruleService() {
        return ruleService;
    }

    @Override
    public IUserService userService() {
        return userService;
    }

    @Override
    public IVGDOService vgdoService() {
        return vgdoService;
    }

    @Override
    public IPartnerService partnerService() {
        return partnerService;
    }

    @Override
    public IProvisioningService provisioningService() {
        return provisioningService;
    }
}
