package com.ryanrvldo.devhub.core.domain.usecase.login

import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.model.AccessToken
import com.ryanrvldo.devhub.core.domain.repository.LoginRepository
import com.ryanrvldo.devhub.core.domain.usecase.accesstoken.WriteUserAccessTokenUseCase
import com.ryanrvldo.devhub.core.exception.IllegalResourceClassException
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val checkUserLoginStatusUseCase: CheckUserLoginStatusUseCase,
    private val writeUserAccessTokenUseCase: WriteUserAccessTokenUseCase,
    private val loginRepository: LoginRepository,
) : LoginUseCase {

    override fun checkUserLoginStatus(): Resource<Boolean> {
        return when (val result = checkUserLoginStatusUseCase.checkStatus()) {
            is Resource.Success -> Resource.Success(result.data!!)
            is Resource.Error -> Resource.Error(result.message.toString())
            else -> throw IllegalResourceClassException()
        }
    }

    override fun getUserAccessToken(code: String): Flow<Resource<AccessToken>> {
        return loginRepository.getAccessToken(code)
    }

    override fun writeUserAccessToken(accessToken: String) {
        writeUserAccessTokenUseCase.writeAccessToken(accessToken)
    }

}
