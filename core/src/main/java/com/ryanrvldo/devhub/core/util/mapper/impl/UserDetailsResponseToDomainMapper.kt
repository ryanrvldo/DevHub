package com.ryanrvldo.devhub.core.util.mapper.impl

import com.ryanrvldo.devhub.core.data.source.remote.response.profile.UserDetailsResponse
import com.ryanrvldo.devhub.core.domain.model.profile.UserDetails
import com.ryanrvldo.devhub.core.util.mapper.Mapper
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableBoolean
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableInteger
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableString

object UserDetailsResponseToDomainMapper : Mapper<UserDetailsResponse, UserDetails> {

    override fun map(input: UserDetailsResponse): UserDetails {
        return with(input) {
            UserDetails(
                username = validateNullableString(username),
                id = validateNullableInteger(id),
                nodeId = validateNullableString(nodeId),
                avatarUrl = validateNullableString(avatarUrl),
                gravatarId = validateNullableString(gravatarId),
                apiUrl = validateNullableString(apiUrl),
                profileUrl = validateNullableString(profileUrl),
                type = validateNullableString(type),
                isSiteAdmin = validateNullableBoolean(isSiteAdmin),
                name = validateNullableString(name),
                company = validateNullableString(company),
                blog = validateNullableString(blog),
                location = validateNullableString(location),
                email = validateNullableString(email),
                bio = validateNullableString(bio),
                twitterUsername = validateNullableString(twitterUsername),
                totalPublicRepos = validateNullableInteger(totalPublicRepos),
                totalPublicGists = validateNullableInteger(totalPublicGists),
                totalFollowers = validateNullableInteger(totalFollowers),
                totalFollowing = validateNullableInteger(totalFollowing),
                createdAt = validateNullableString(createdAt),
                updatedAt = validateNullableString(updatedAt),
                totalPrivateRepos = validateNullableInteger(totalPrivateRepos),
                totalPrivateGists = validateNullableInteger(totalPrivateGists),
                totalOwnedPrivateRepos = validateNullableInteger(totalOwnedPrivateRepos),
                totalDiskUsage = validateNullableInteger(totalDiskUsage),
                collaborators = validateNullableInteger(collaborators),
                isTwoFactoryEnabled = validateNullableBoolean(isTwoFactoryEnabled),
                userPlan = UserPlanResponseToDomainMapper.map(userPlanResponse)
            )
        }
    }

}
