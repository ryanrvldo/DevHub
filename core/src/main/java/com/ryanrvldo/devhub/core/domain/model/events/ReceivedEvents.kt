package com.ryanrvldo.devhub.core.domain.model.events

data class ReceivedEvents(
    val id: String,
    val type: String,
    val actor: Actor,
    val repo: Repo,
    val payload: Payload,
    val createdAt: String,
    val organization: Organization,
    val isPublic: Boolean,
)
