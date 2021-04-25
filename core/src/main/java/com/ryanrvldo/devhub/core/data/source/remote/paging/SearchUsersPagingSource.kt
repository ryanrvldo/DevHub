package com.ryanrvldo.devhub.core.data.source.remote.paging

import androidx.paging.PagingSource
import com.ryanrvldo.devhub.core.data.source.remote.network.ApiService
import com.ryanrvldo.devhub.core.domain.model.search.User
import com.ryanrvldo.devhub.core.util.mapper.impl.ListUserResponseToDomainMapper
import okio.IOException
import retrofit2.HttpException
import kotlin.math.ceil

class SearchUsersPagingSource(
    private val service: ApiService,
    private val query: String,
) : PagingSource<Int, User>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val position = params.key ?: 1
        return try {
            val response = service.searchUsers(query, position)
            val listUser = ListUserResponseToDomainMapper.map(response)
            val users = listUser.users
            val totalPage = (ceil(listUser.totalCount / 100.0)).toInt()
            if (listUser.totalCount == 0 || users.isEmpty()) {
                return LoadResult.Error(Throwable("Sorry, the user you are looking for does not exist. Please enter another keyword."))
            }
            LoadResult.Page(
                data = users,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == totalPage) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}
