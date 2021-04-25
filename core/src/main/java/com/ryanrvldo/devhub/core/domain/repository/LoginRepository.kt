package com.ryanrvldo.devhub.core.domain.repository

import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.model.token.AccessToken
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun getAccessToken(code: String): Flow<Resource<AccessToken>>

}
