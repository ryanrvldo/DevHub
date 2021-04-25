package com.ryanrvldo.devhub.core.data.repository.fake

import com.ryanrvldo.devhub.core.data.DummyData
import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.data.source.remote.network.ApiResponse
import com.ryanrvldo.devhub.core.domain.model.token.AccessToken
import com.ryanrvldo.devhub.core.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeLoginRepository : LoginRepository {

    companion object {
        var apiResponse = DummyData.getDummySuccessApiResponse()
    }

    override fun getAccessToken(code: String): Flow<Resource<AccessToken>> = flow {
        emit(Resource.Loading())
        when (apiResponse) {
            is ApiResponse.Success -> {
                emit(Resource.Success(DummyData.getDummyAccessTokenDomain()))
            }
            is ApiResponse.Empty -> {
                emit(Resource.Error<AccessToken>("Null responses from server."))
            }
            is ApiResponse.Error -> {
                emit(Resource.Error<AccessToken>((apiResponse as ApiResponse.Error).errorMessage))
            }
        }
    }

}
