package com.ryanrvldo.devhub.core.data.source.remote

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ryanrvldo.devhub.core.data.source.remote.network.ApiResponse
import com.ryanrvldo.devhub.core.data.source.remote.network.ApiService
import com.ryanrvldo.devhub.core.data.source.remote.network.LoginService
import com.ryanrvldo.devhub.core.data.source.remote.paging.ReceivedEventsPagingSource
import com.ryanrvldo.devhub.core.data.source.remote.paging.SearchUsersPagingSource
import com.ryanrvldo.devhub.core.data.source.remote.response.profile.UserDetailsResponse
import com.ryanrvldo.devhub.core.data.source.remote.response.token.AccessTokenResponse
import com.ryanrvldo.devhub.core.domain.model.events.ReceivedEvents
import com.ryanrvldo.devhub.core.domain.model.search.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService,
    private val loginService: LoginService,
) {

    fun getAccessToken(code: String): Flow<ApiResponse<AccessTokenResponse>> = flow {
        val response = loginService.getAccessToken(code = code)
        val accessToken = response.accessToken
        if (accessToken.isNullOrBlank()) {
            emit(ApiResponse.Empty)
        } else {
            emit(ApiResponse.Success(response))
        }
    }.catch { exception ->
        emit(ApiResponse.Error(exception.message.toString()))
        Log.e(this@RemoteDataSource::class.simpleName,
            "getAccessToken: ${exception.message}",
            exception)
    }.flowOn(Dispatchers.IO)

    fun getUserDetails(oauthToken: String): Flow<ApiResponse<UserDetailsResponse>> = flow {
        try {
            val response = apiService.getUserDetails("token $oauthToken")
            val userId = response.id ?: 0
            if (userId <= 0) {
                emit(ApiResponse.Empty)
            } else {
                emit(ApiResponse.Success(response))
            }
        } catch (exception: Exception) {
            emit(ApiResponse.Error(exception.message.toString()))
            Log.e(this@RemoteDataSource::class.simpleName,
                "getUserDetails: ${exception.message}",
                exception)
        }
    }.flowOn(Dispatchers.IO)

    fun getUserReceivedEvents(
        oauthToken: String,
        username: String,
    ): Flow<PagingData<ReceivedEvents>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 40,
                prefetchDistance = 5,
                initialLoadSize = 40
            ),
            pagingSourceFactory = { ReceivedEventsPagingSource(apiService, oauthToken, username) }
        ).flow
    }

    fun getSearchUsers(query: String): Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 100,
                prefetchDistance = 5,
                initialLoadSize = 40
            ),
            pagingSourceFactory = { SearchUsersPagingSource(apiService, query) }
        ).flow
    }

}
