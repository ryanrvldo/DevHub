package com.ryanrvldo.devhub.core.data.source.remote.paging

import androidx.paging.PagingSource
import com.ryanrvldo.devhub.core.data.source.remote.network.ApiService
import com.ryanrvldo.devhub.core.domain.model.events.ReceivedEvents
import com.ryanrvldo.devhub.core.util.mapper.impl.ReceivedEventsItemResponseToDomainMapper
import okio.IOException
import retrofit2.HttpException

class ReceivedEventsPagingSource(
    private val service: ApiService,
    private val oauthToken: String,
    private val username: String,
) : PagingSource<Int, ReceivedEvents>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ReceivedEvents> {
        val position = params.key ?: 1
        return try {
            val response = service.getUserReceivedEvents("token $oauthToken", username, position)
            val listEvents = response.map { ReceivedEventsItemResponseToDomainMapper.map(it) }
            val totalPage = 15
            if (listEvents.isEmpty()) {
                return LoadResult.Error(Throwable("Sorry, the received events is empty. Please try again later."))
            }
            LoadResult.Page(
                data = listEvents,
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
