package com.ryanrvldo.devhub.core.domain.usecase.user

import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.model.UserDetails
import kotlinx.coroutines.flow.Flow

interface GetUserDetailsUseCase {

    fun getUserDetails(): Flow<Resource<UserDetails>>

}
