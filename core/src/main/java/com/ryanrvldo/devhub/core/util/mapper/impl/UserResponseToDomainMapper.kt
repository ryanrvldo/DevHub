package com.ryanrvldo.devhub.core.util.mapper.impl

import com.ryanrvldo.devhub.core.data.source.remote.response.search.UserResponse
import com.ryanrvldo.devhub.core.domain.model.search.User
import com.ryanrvldo.devhub.core.util.mapper.Mapper
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableInteger
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableString

object UserResponseToDomainMapper : Mapper<UserResponse, User> {

    override fun map(input: UserResponse): User {
        return with(input) {
            User(
                id = validateNullableInteger(id),
                username = validateNullableString(username),
                avatarUrl = validateNullableString(avatarUrl),
                url = validateNullableString(url)
            )
        }
    }

}
