package com.ryanrvldo.devhub.core.data.source.remote.response.events

import com.google.gson.annotations.SerializedName

data class OrganizationResponse(
    @field:SerializedName("id") val id: Int?,
    @field:SerializedName("login") val name: String?,
    @field:SerializedName("url") val url: String?,
    @field:SerializedName("avatar_url") val avatarUrl: String?,
)
