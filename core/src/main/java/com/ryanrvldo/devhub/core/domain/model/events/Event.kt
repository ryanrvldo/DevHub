package com.ryanrvldo.devhub.core.domain.model.events

enum class Event(val type: String, val event: String) {
    STARRED("WatchEvent", "starred"),
    MADE_PUBLIC("PublicEvent", "made public"),
    CREATED("CreateEvent", "created a repository"),
    FORKED("ForkEvent", "forked")
}
