package com.ryanrvldo.devhub.core.util.mapper.impl

import com.ryanrvldo.devhub.core.data.source.remote.response.search.ListUserResponse
import com.ryanrvldo.devhub.core.domain.model.search.Users
import com.ryanrvldo.devhub.core.util.mapper.Mapper
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableBoolean
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableInteger

object ListUserResponseToDomainMapper : Mapper<ListUserResponse, Users> {

    override fun map(input: ListUserResponse): Users {
        return with(input) {
            Users(
                totalCount = validateNullableInteger(totalCount),
                incompleteResults = validateNullableBoolean(incompleteResults),
                users = users?.map { UserResponseToDomainMapper.map(it) }.orEmpty()
            )
        }
    }

}
