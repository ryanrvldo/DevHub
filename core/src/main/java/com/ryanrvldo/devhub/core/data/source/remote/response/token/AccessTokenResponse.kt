package com.ryanrvldo.devhub.core.data.source.remote.response.token

import com.google.gson.annotations.SerializedName

data class AccessTokenResponse(
    @field:SerializedName("access_token") val accessToken: String?,
    @field:SerializedName("token_type") val tokenType: String?,
    @field:SerializedName("scope") val scope: String?,
)
