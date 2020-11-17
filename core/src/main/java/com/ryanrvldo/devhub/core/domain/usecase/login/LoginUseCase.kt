package com.ryanrvldo.devhub.core.domain.usecase.login

import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.model.AccessToken
import kotlinx.coroutines.flow.Flow

interface LoginUseCase {

    fun checkUserLoginStatus(): Resource<Boolean>

    fun getUserAccessToken(code: String): Flow<Resource<AccessToken>>

    fun writeUserAccessToken(accessToken: String)

}
