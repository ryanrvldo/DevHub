package com.ryanrvldo.devhub.core.domain.usecase.accesstoken

import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.repository.SharedPrefRepository
import com.ryanrvldo.devhub.core.exception.IllegalResourceClassException
import javax.inject.Inject

class ReadUserAccessTokenUseCaseImpl @Inject constructor(
    private val sharedPrefRepository: SharedPrefRepository,
) : ReadUserAccessTokenUseCase {

    override fun readAccessToken(): Resource<String> {
        return when (val result = sharedPrefRepository.getUserToken()) {
            is Resource.Success -> Resource.Success(result.data.toString())
            is Resource.Error -> Resource.Error(result.message!!)
            else -> throw IllegalResourceClassException()
        }
    }

}
