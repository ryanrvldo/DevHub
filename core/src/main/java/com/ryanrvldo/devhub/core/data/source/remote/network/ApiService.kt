package com.ryanrvldo.devhub.core.data.source.remote.network

import com.ryanrvldo.devhub.core.data.source.remote.response.profile.UserDetailsResponse
import com.ryanrvldo.devhub.core.data.source.remote.response.search.ListUserResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 100,
    ): ListUserResponse

    @GET("user")
    suspend fun getUserDetails(
        @Header("Authorization") authorization: String,
    ): UserDetailsResponse

}
