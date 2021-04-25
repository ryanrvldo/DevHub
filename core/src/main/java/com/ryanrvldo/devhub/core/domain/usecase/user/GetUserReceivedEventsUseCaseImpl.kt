package com.ryanrvldo.devhub.core.domain.usecase.user

import androidx.paging.PagingData
import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.model.events.ReceivedEvents
import com.ryanrvldo.devhub.core.domain.repository.UserRepository
import com.ryanrvldo.devhub.core.domain.usecase.accesstoken.ReadUserAccessTokenUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserReceivedEventsUseCaseImpl @Inject constructor(
    private val readUserAccessTokenUseCase: ReadUserAccessTokenUseCase,
    private val userRepository: UserRepository,
) : GetUserReceivedEventsUseCase {

    override fun getEvents(username: String): Flow<PagingData<ReceivedEvents>> {
        return when (val result = readUserAccessTokenUseCase.readAccessToken()) {
            is Resource.Success -> result.data?.let {
                userRepository.getUserReceivedEvents(it,
                    username)
            } ?: throw KotlinNullPointerException("Expression 'result.data' must not be null")
            is Resource.Error -> throw Exception(result.message.toString())
            else -> throw Exception("Unknown error.")
        }
    }

}
