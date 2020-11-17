package com.ryanrvldo.devhub.core.domain.usecase.login

import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.usecase.accesstoken.ReadUserAccessTokenUseCase
import com.ryanrvldo.devhub.core.exception.IllegalResourceClassException
import javax.inject.Inject

class CheckUserLoginStatusUseCaseImpl @Inject constructor(
    private val readUserAccessTokenUseCase: ReadUserAccessTokenUseCase,
) : CheckUserLoginStatusUseCase {

    override fun checkStatus(): Resource<Boolean> {
        return when (val result = readUserAccessTokenUseCase.readAccessToken()) {
            is Resource.Success -> Resource.Success(!result.data.equals("null"))
            is Resource.Error -> Resource.Error(result.message.toString())
            else -> throw IllegalResourceClassException()
        }
    }

}
