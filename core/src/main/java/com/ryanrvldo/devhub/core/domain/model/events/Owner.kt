package com.ryanrvldo.devhub.core.domain.model.events

data class Owner(
    val username: String,
    val id: Int,
    val nodeId: String,
    val avatarUrl: String,
    val url: String,
    val htmlUrl: String,
)
