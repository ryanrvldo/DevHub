package com.ryanrvldo.devhub.core.domain.repository

import androidx.paging.PagingData
import com.ryanrvldo.devhub.core.domain.model.search.User
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun getSearchUsers(query: String): Flow<PagingData<User>>

}
