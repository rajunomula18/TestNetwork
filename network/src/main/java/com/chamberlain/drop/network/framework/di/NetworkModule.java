/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network.framework.di;

import com.chamberlain.drop.network.framework.TokenAuthenticatorHelper;
import com.chamberlain.drop.network.framework.network.HeaderInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class NetworkModule {
    private static final String APPLICATION_ID = "application_id";
    private static final String SECURITY_TOKEN = "security_token";

    private final String applicationId;
    private final String securityToken;
    private final boolean enableDebugLogging;

    NetworkModule(String applicationId, String securityToken, boolean enableDebugLogging) {
        this.applicationId = applicationId;
        this.securityToken = securityToken;
        this.enableDebugLogging = enableDebugLogging;
    }

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitBuilder(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient);
    }

    @Provides
    @Named(APPLICATION_ID)
    String provideMyQApplicationId() {
        return applicationId;
    }

    @Provides
    @Named(SECURITY_TOKEN)
    String provideSecurityToken() {
        return securityToken;
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HeaderInterceptor headerInterceptor,
                                     HttpLoggingInterceptor httpLoggingInterceptor,
                                     TokenAuthenticatorHelper tokenAuthenticatorHelper) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .addInterceptor(headerInterceptor)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .authenticator(tokenAuthenticatorHelper);


        if (enableDebugLogging) {
            okHttpClientBuilder
                    .addInterceptor(httpLoggingInterceptor);
        }

        return okHttpClientBuilder.build();
    }

    @Provides
    @Singleton
    HeaderInterceptor provideHeaderInterceptor(@Named(SECURITY_TOKEN) String securityToken, @Named(APPLICATION_ID) String applicationId) {
        return new HeaderInterceptor(securityToken, applicationId);
    }

    @Provides
    @Singleton
    TokenAuthenticatorHelper provideTokenAuthenticator() {
        return new TokenAuthenticatorHelper();
    }
}
