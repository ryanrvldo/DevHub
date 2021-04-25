package com.ryanrvldo.devhub.core.data.source.remote.response.events

import com.google.gson.annotations.SerializedName

data class ForkEventResponse(
    @field:SerializedName("id") val id: Int?,
    @field:SerializedName("node_id") val nodeId: String?,
    @field:SerializedName("name") val name: String?,
    @field:SerializedName("full_name") val fullName: String?,
    @field:SerializedName("owner") val ownerResponse: OwnerResponse?,
    @field:SerializedName("html_url") val htmlUrl: String?,
    @field:SerializedName("description") val description: String?,
    @field:SerializedName("url") val url: String?,
)
