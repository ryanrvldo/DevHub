package com.ryanrvldo.devhub.core.data.source.remote.response.events

import com.google.gson.annotations.SerializedName

data class ActorResponse(
    @field:SerializedName("id") val id: Int?,
    @field:SerializedName("login") val username: String?,
    @field:SerializedName("url") val url: String?,
    @field:SerializedName("avatar_url") val avatarUrl: String?,
)
