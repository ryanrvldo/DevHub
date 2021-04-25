package com.ryanrvldo.devhub.core.util.mapper.impl

import com.ryanrvldo.devhub.core.data.source.remote.response.profile.UserPlanResponse
import com.ryanrvldo.devhub.core.domain.model.profile.UserPlan
import com.ryanrvldo.devhub.core.util.mapper.Mapper
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableInteger
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableString

object UserPlanResponseToDomainMapper : Mapper<UserPlanResponse?, UserPlan> {

    override fun map(input: UserPlanResponse?): UserPlan {
        input?.let { response ->
            return with(response) {
                UserPlan(
                    name = validateNullableString(name),
                    space = validateNullableInteger(space),
                    collaborators = validateNullableInteger(collaborators),
                    maxPrivateRepos = validateNullableInteger(maxPrivateRepos)
                )
            }
        } ?: return UserPlan("", -1, -1, -1)
    }

}
