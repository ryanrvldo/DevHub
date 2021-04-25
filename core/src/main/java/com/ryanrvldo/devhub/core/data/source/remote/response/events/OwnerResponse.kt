package com.ryanrvldo.devhub.core.data.source.remote.response.events

import com.google.gson.annotations.SerializedName

data class OwnerResponse(
    @field:SerializedName("login") val username: String?,
    @field:SerializedName("id") val id: Int?,
    @field:SerializedName("node_id") val nodeId: String?,
    @field:SerializedName("avatar_url") val avatarUrl: String?,
    @field:SerializedName("url") val url: String?,
    @field:SerializedName("html_url") val htmlUrl: String?,
)
