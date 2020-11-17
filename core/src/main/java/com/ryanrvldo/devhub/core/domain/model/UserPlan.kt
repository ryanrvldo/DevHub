package com.ryanrvldo.devhub.core.domain.model

data class UserPlan(
    val name: String,
    val space: Int,
    val collaborators: Int,
    val maxPrivateRepos: Int,
)
