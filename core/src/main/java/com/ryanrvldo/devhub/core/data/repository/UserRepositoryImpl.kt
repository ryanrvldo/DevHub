package com.ryanrvldo.devhub.core.data.repository

import androidx.paging.PagingData
import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.data.source.remote.RemoteDataSource
import com.ryanrvldo.devhub.core.data.source.remote.network.ApiResponse
import com.ryanrvldo.devhub.core.domain.model.events.ReceivedEvents
import com.ryanrvldo.devhub.core.domain.model.profile.UserDetails
import com.ryanrvldo.devhub.core.domain.repository.UserRepository
import com.ryanrvldo.devhub.core.util.mapper.impl.UserDetailsResponseToDomainMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : UserRepository {

    override fun getUserDetails(oauthToken: String): Flow<Resource<UserDetails>> = flow {
        emit(Resource.Loading())
        when (val response = remoteDataSource.getUserDetails(oauthToken).first()) {
            is ApiResponse.Success -> emit(
                Resource.Success(UserDetailsResponseToDomainMapper.map(response.data))
            )
            is ApiResponse.Empty -> emit(Resource.Error<UserDetails>("Empty response from server."))
            is ApiResponse.Error -> emit(Resource.Error<UserDetails>(response.errorMessage))
        }
    }

    override fun getUserReceivedEvents(
        oauthToken: String,
        username: String,
    ): Flow<PagingData<ReceivedEvents>> {
        return remoteDataSource.getUserReceivedEvents(oauthToken, username)
    }

}
