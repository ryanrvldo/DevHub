package com.ryanrvldo.devhub.core.data.source.remote.response.search

import com.google.gson.annotations.SerializedName

data class ListUserResponse(
    @field:SerializedName("total_count") val totalCount: Int?,
    @field:SerializedName("incomplete_results") val incompleteResults: Boolean?,
    @field:SerializedName("items") val users: List<UserResponse>?,
)
