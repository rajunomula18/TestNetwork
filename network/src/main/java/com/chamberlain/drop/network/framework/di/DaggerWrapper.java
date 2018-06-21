/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network.framework.di;

public class DaggerWrapper {
    private static FrameworkComponent mComponent;

    public static FrameworkComponent getComponent(String applicationId,
                                                  String securityToken,
                                                  String baseUrl,
                                                  String deliveryUrl,
                                                  String provisioningUrl,
                                                  boolean enableDebugLogging) {
        if (mComponent == null) {
            initComponent(applicationId, securityToken, baseUrl, deliveryUrl, provisioningUrl, enableDebugLogging);
        }
        return mComponent;
    }

    public static FrameworkComponent resetFrameworkComponent(String applicationId,
                                               String securityToken,
                                               String baseUrl,
                                               String deliveryUrl,
                                               String provisioningUrl,
                                               boolean enableDebugLogging){
        initComponent(applicationId, securityToken, baseUrl, deliveryUrl, provisioningUrl, enableDebugLogging);
        return mComponent;
    }

    private static void initComponent(String applicationId,
                                      String securityToken,
                                      String baseUrl,
                                      String deliveryUrl,
                                      String provisioningUrl,
                                      boolean enableDebugLogging) {
        mComponent = DaggerFrameworkComponent
                .builder()
                .networkModule(new NetworkModule(applicationId, securityToken, enableDebugLogging))
                .servicesModule(new ServicesModule(baseUrl, deliveryUrl, provisioningUrl))
                .build();
    }
}
