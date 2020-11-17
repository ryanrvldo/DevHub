package com.ryanrvldo.devhub.core.domain.repository

import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.model.UserDetails
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUserDetails(oauthToken: String): Flow<Resource<UserDetails>>

}
