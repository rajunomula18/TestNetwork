/*
 *
 *    © 2018 Chamberlain Group.  All rights reserved.
 *    All information within this file and associated files, including all information
 *    and files transferred with this file are CONFIDENTIAL and the proprietary
 *    property of The Chamberlain Group, Inc.
 *
 */

package com.chamberlain.drop.network.framework.network.retrofit;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface AccountServiceV5 {
    @GET("api/v5/Accounts/{accountId}")
    Call<ResponseBody> getAccounts(@Path("accountId") String accountId,
                                   @QueryMap Map<String, String> params);

    @GET("api/v5/Accounts")
    Call<ResponseBody> getAccounts(@QueryMap Map<String, String> params);

    @PUT("api/v5/Accounts/{accountId}")
    Call<ResponseBody> updateAccount(@Path("accountId") String accountId,
                                     @Body RequestBody requestBody);

    @GET("api/v5/My/Users")
    Call<ResponseBody> getMyAccountUsers(@QueryMap Map<String, String> params);

    @POST("api/v5/Accounts/{accountId}/Users")
    Call<ResponseBody> createAccountUser(@Path("accountId") String accountId,
                                         @Body RequestBody requestBody);

    @POST("api/v5/Accounts/{accountId}/Users/{userId}/InviteToLink")
    Call<ResponseBody> inviteUser(@Path("accountId") String accountId,
                                  @Path("userId") String userId,
                                  @Body RequestBody requestBody);

    @DELETE("api/v5/Accounts/{accountId}/Users/{userId}")
    Call<ResponseBody> deleteAccountUser(@Path("accountId") String accountId,
                                         @Path("userId") String userId);

    @GET("api/v5/Accounts/{accountId}/Users")
    Call<ResponseBody> getAccountUser(@Path("accountId") String accountId,
                                      @QueryMap Map<String, String> params);


    @GET("api/v5/Accounts/{accountId}/Users/{userId}/Roles")
    Call<ResponseBody> getAccountUserRoles(@Path("accountId") String accountId,
                                           @Path("userId") String userId);

    @POST("api/v5/My/CompleteAccountLinking")
    Call<ResponseBody> completeAccountLinking(@Body RequestBody requestBody);

    @GET("api/v5/Invitations/{invitationId}")
    Call<ResponseBody> getInvitationStatus(@Path("invitationId") String invitationId);

    @GET("api/v5/My/Invitations/")
    Call<ResponseBody> getMyInvitations();

    @POST("api/v5/My/invitations/{invitationId}/Accept")
    Call<ResponseBody> acceptMyInvitation(@Path("invitationId") String invitationId);

    @DELETE("api/v5/My/Invitations/{invitationId}")
    Call<ResponseBody> denyMyInvitation(@Path("invitationId") String invitationId);

    @GET("api/v5/Accounts/{accountId}/Roles")
    Call<ResponseBody> getAccountRoles(@Path("accountId") String accountId);

    @PUT("api/v5/Accounts/{accountId}/Users/{userId}/Roles")
    Call<ResponseBody> updateAccountUserRoles(@Path("accountId") String accountId,
                                              @Path("userId") String userId,
                                              @Body RequestBody requestBody);

}
