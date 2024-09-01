package com.karnamic.reststarter.data.remote

import com.karnamic.reststarter.data.remote.responses.AuthAccessTokenResponse
import com.karnamic.reststarter.data.remote.responses.AuthUserProfileResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthService {

    @FormUrlEncoded
    @POST("/auth/o2/token")
    suspend fun getAccessToken(
        @Field("grant_type") grantType: String,
        @Field("code") code: String?,
        @Field("redirect_uri") redirectUri: String,
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("refresh_token") refreshToken: String? = null
    ): AuthAccessTokenResponse

    @GET("/user/profile")
    suspend fun getUserProfile(
        @Header("Authorization") authorization: String
    ): AuthUserProfileResponse
}