package com.ryanrvldo.devhub.core.data.source.remote.network

import com.ryanrvldo.devhub.core.BuildConfig
import com.ryanrvldo.devhub.core.data.source.remote.response.token.AccessTokenResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {

    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("access_token")
    suspend fun getAccessToken(
        @Field("client_id") clientId: String = BuildConfig.CLIENT_ID,
        @Field("client_secret") clientSecret: String = BuildConfig.CLIENT_SECRET,
        @Field("code") code: String,
    ): AccessTokenResponse

}
