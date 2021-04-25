package com.ryanrvldo.devhub.core.data.source.remote.response.events

import com.google.gson.annotations.SerializedName

data class ReceivedEventsResponse(
    @field:SerializedName("id") val id: String?,
    @field:SerializedName("type") val type: String?,
    @field:SerializedName("actor") val actorResponse: ActorResponse?,
    @field:SerializedName("repo") val repoResponse: RepoResponse?,
    @field:SerializedName("payload") val payloadResponse: PayloadResponse?,
    @field:SerializedName("created_at") val createdAt: String?,
    @field:SerializedName("org") val organizationResponse: OrganizationResponse?,
    @field:SerializedName("public") val isPublic: Boolean?,
)
