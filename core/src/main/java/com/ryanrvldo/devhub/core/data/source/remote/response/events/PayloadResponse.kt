package com.ryanrvldo.devhub.core.data.source.remote.response.events

import com.google.gson.annotations.SerializedName

data class PayloadResponse(
    @field:SerializedName("action") val action: String?,
    @field:SerializedName("ref_type") val refType: String?,
    @field:SerializedName("master_branch") val masterBranch: String?,
    @field:SerializedName("description") val description: String?,
    @field:SerializedName("pusher_type") val pusherType: String?,
    @field:SerializedName("forkee") val forkEventResponse: ForkEventResponse?,
)
