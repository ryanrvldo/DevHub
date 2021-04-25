package com.ryanrvldo.devhub.core.domain.usecase

import androidx.paging.PagingData
import com.ryanrvldo.devhub.core.domain.model.search.User
import com.ryanrvldo.devhub.core.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUseCaseImpl @Inject constructor(
    private val searchRepository: SearchRepository,
) : SearchUseCase {

    override fun getSearchUsers(query: String): Flow<PagingData<User>> {
        return searchRepository.getSearchUsers(query)
    }

}
