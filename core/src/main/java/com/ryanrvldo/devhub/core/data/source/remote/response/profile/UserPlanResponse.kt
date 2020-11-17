package com.ryanrvldo.devhub.core.data.source.remote.response.profile

import com.google.gson.annotations.SerializedName

data class UserPlanResponse(
    @field:SerializedName("name") val name: String?,
    @field:SerializedName("space") val space: Int?,
    @field:SerializedName("collaborators") val collaborators: Int?,
    @field:SerializedName("private_repos") val maxPrivateRepos: Int?,
)
