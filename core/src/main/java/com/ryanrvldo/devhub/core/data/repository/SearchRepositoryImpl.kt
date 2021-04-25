package com.ryanrvldo.devhub.core.data.repository

import androidx.paging.PagingData
import com.ryanrvldo.devhub.core.data.source.remote.RemoteDataSource
import com.ryanrvldo.devhub.core.domain.model.search.User
import com.ryanrvldo.devhub.core.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : SearchRepository {

    override fun getSearchUsers(query: String): Flow<PagingData<User>> {
        return remoteDataSource.getSearchUsers(query)
    }

}
