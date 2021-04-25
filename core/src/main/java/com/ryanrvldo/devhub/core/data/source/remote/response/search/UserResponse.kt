package com.ryanrvldo.devhub.core.data.source.remote.response.search

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @field:SerializedName("id") val id: Int?,
    @field:SerializedName("login") val username: String?,
    @field:SerializedName("avatar_url") val avatarUrl: String?,
    @field:SerializedName("url") val url: String?,
)
