package com.ryanrvldo.devhub.core.domain.model.events

data class ForkEvent(
    val id: Int,
    val nodeId: String,
    val name: String,
    val fullName: String,
    val owner: Owner,
    val htmlUrl: String,
    val description: String,
    val url: String,
)
