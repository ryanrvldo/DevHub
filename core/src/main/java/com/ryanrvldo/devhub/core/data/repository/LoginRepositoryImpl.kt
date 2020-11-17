package com.ryanrvldo.devhub.core.data.repository

import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.data.source.remote.RemoteDataSource
import com.ryanrvldo.devhub.core.data.source.remote.network.ApiResponse
import com.ryanrvldo.devhub.core.domain.model.AccessToken
import com.ryanrvldo.devhub.core.domain.repository.LoginRepository
import com.ryanrvldo.devhub.core.util.mapper.impl.AccessTokenResponseToDomainMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : LoginRepository {

    override fun getAccessToken(code: String): Flow<Resource<AccessToken>> = flow {
        emit(Resource.Loading())
        when (val response = remoteDataSource.getAccessToken(code).first()) {
            is ApiResponse.Success -> emit(
                Resource.Success(AccessTokenResponseToDomainMapper.map(response.data))
            )
            is ApiResponse.Empty -> emit(Resource.Error<AccessToken>("Null responses from server."))
            is ApiResponse.Error -> emit(Resource.Error<AccessToken>(response.errorMessage))
        }
    }

}
