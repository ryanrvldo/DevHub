package com.ryanrvldo.devhub.core.data.source.remote.response.events

import com.google.gson.annotations.SerializedName

data class RepoResponse(
    @field:SerializedName("id") val id: Int?,
    @field:SerializedName("name") val name: String?,
    @field:SerializedName("url") val url: String?,
)
