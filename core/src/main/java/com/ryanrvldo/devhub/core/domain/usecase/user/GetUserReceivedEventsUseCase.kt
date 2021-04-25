package com.ryanrvldo.devhub.core.domain.usecase.user

import androidx.paging.PagingData
import com.ryanrvldo.devhub.core.domain.model.events.ReceivedEvents
import kotlinx.coroutines.flow.Flow

interface GetUserReceivedEventsUseCase {

    fun getEvents(username: String): Flow<PagingData<ReceivedEvents>>

}
