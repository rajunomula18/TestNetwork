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

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ServicesModule.class, NetworkModule.class})
public interface FrameworkComponent {
    INetworkFramework networkFramework();
}
