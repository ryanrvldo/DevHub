package com.ryanrvldo.devhub.core.domain.repository

import androidx.paging.PagingData
import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.domain.model.events.ReceivedEvents
import com.ryanrvldo.devhub.core.domain.model.profile.UserDetails
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUserDetails(oauthToken: String): Flow<Resource<UserDetails>>

    fun getUserReceivedEvents(
        oauthToken: String,
        username: String,
    ): Flow<PagingData<ReceivedEvents>>
}
