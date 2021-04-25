package com.ryanrvldo.devhub.core.util.mapper.impl

import com.ryanrvldo.devhub.core.data.source.remote.response.events.ForkEventResponse
import com.ryanrvldo.devhub.core.domain.model.events.ForkEvent
import com.ryanrvldo.devhub.core.domain.model.events.Owner
import com.ryanrvldo.devhub.core.util.mapper.Mapper
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableInteger
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableString

object ForkEventResponseToDomainMapper : Mapper<ForkEventResponse?, ForkEvent> {

    override fun map(input: ForkEventResponse?): ForkEvent {
        input?.let { response ->
            return with(response) {
                ForkEvent(
                    id = validateNullableInteger(id),
                    nodeId = validateNullableString(nodeId),
                    name = validateNullableString(name),
                    fullName = validateNullableString(fullName),
                    owner = OwnerResponseToDomainMapper.map(ownerResponse),
                    htmlUrl = validateNullableString(htmlUrl),
                    description = validateNullableString(description),
                    url = validateNullableString(url),
                )
            }
        } ?: return ForkEvent(
            id = -1,
            nodeId = "",
            name = "",
            fullName = "",
            owner = Owner("", -1, "", "", "", ""),
            htmlUrl = "",
            description = "",
            url = "",
        )
    }

}
