package com.ryanrvldo.devhub.core.util.mapper.impl

import com.ryanrvldo.devhub.core.data.source.remote.response.events.OwnerResponse
import com.ryanrvldo.devhub.core.domain.model.events.Owner
import com.ryanrvldo.devhub.core.util.mapper.Mapper
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableInteger
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableString

object OwnerResponseToDomainMapper : Mapper<OwnerResponse?, Owner> {

    override fun map(input: OwnerResponse?): Owner {
        input?.let { response ->
            return with(response) {
                Owner(
                    username = validateNullableString(username),
                    id = validateNullableInteger(id),
                    nodeId = validateNullableString(nodeId),
                    avatarUrl = validateNullableString(avatarUrl),
                    url = validateNullableString(url),
                    htmlUrl = validateNullableString(htmlUrl)
                )
            }
        } ?: return Owner("", -1, "", "", "", "")
    }

}
