package com.ryanrvldo.devhub.core.domain.model

data class UserDetails(
    val username: String,
    val id: Int,
    val nodeId: String,
    val avatarUrl: String,
    val gravatarId: String,
    val apiUrl: String,
    val profileUrl: String,
    val type: String,
    val isSiteAdmin: Boolean,
    val name: String,
    val company: String,
    val blog: String,
    val location: String,
    val email: String,
    val bio: String,
    val twitterUsername: String,
    val totalPublicRepos: Int,
    val totalPublicGists: Int,
    val totalFollowers: Int,
    val totalFollowing: Int,
    val createdAt: String,
    val updatedAt: String,
    val totalPrivateGists: Int,
    val totalPrivateRepos: Int,
    val totalOwnedPrivateRepos: Int,
    val totalDiskUsage: Int,
    val collaborators: Int,
    val isTwoFactoryEnabled: Boolean,
    val userPlan: UserPlan,
)
