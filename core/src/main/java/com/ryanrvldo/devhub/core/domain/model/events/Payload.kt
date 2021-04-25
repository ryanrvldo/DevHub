package com.ryanrvldo.devhub.core.domain.model.events

data class Payload(
    val action: String,
    val refType: String,
    val masterBranch: String,
    val description: String,
    val pusherType: String,
    val forkEvent: ForkEvent,
)
