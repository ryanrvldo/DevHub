package com.ryanrvldo.devhub.core.domain.usecase.user

import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.model.profile.UserDetails
import com.ryanrvldo.devhub.core.domain.repository.UserRepository
import com.ryanrvldo.devhub.core.domain.usecase.accesstoken.ReadUserAccessTokenUseCase
import com.ryanrvldo.devhub.core.exception.IllegalResourceClassException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUserDetailsUseCaseImpl @Inject constructor(
    private val readUserAccessTokenUseCase: ReadUserAccessTokenUseCase,
    private val userRepository: UserRepository,
) : GetUserDetailsUseCase {

    override fun getUserDetails(): Flow<Resource<UserDetails>> {
        return when (val result = readUserAccessTokenUseCase.readAccessToken()) {
            is Resource.Success -> userRepository.getUserDetails(result.data
                ?: throw NullPointerException("Expression 'result.data' must not be null"))
            is Resource.Error -> flow {
                emit(Resource.Error<UserDetails>(result.message.toString()))
            }
            else -> throw IllegalResourceClassException()
        }
    }

}
