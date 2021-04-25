package com.ryanrvldo.devhub.core.domain.usecase

import androidx.paging.PagingData
import com.ryanrvldo.devhub.core.domain.model.search.User
import kotlinx.coroutines.flow.Flow

interface SearchUseCase {

    fun getSearchUsers(query: String): Flow<PagingData<User>>

}
