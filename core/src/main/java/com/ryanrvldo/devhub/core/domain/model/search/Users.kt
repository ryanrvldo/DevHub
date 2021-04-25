package com.ryanrvldo.devhub.core.domain.model.search

data class Users(
    val totalCount: Int,
    val incompleteResults: Boolean,
    val users: List<User>,
)
