package com.ryanrvldo.devhub.core.domain.usecase.accesstoken

import com.ryanrvldo.devhub.core.domain.repository.SharedPrefRepository
import javax.inject.Inject

class WriteUserAccessTokenUseCaseImpl @Inject constructor(
    private val sharedPrefRepository: SharedPrefRepository,
) : WriteUserAccessTokenUseCase {

    override fun writeAccessToken(value: String) {
        sharedPrefRepository.putUserToken(value)
    }

}
