package com.ryanrvldo.devhub.core.util.mapper.impl

import com.ryanrvldo.devhub.core.data.source.remote.response.events.ReceivedEventsResponse
import com.ryanrvldo.devhub.core.domain.model.events.ReceivedEvents
import com.ryanrvldo.devhub.core.util.mapper.Mapper
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableBoolean
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableString

object ReceivedEventsItemResponseToDomainMapper :
    Mapper<ReceivedEventsResponse, ReceivedEvents> {

    override fun map(input: ReceivedEventsResponse): ReceivedEvents {
        return with(input) {
            ReceivedEvents(
                id = validateNullableString(id),
                type = validateNullableString(type),
                actor = ActorResponseToDomainMapper.map(actorResponse),
                repo = RepoResponseToDomainMapper.map(repoResponse),
                payload = PayloadResponseToDomainMapper.map(payloadResponse),
                createdAt = validateNullableString(createdAt),
                organization = OrganizationResponseToDomainMapper.map(organizationResponse),
                isPublic = validateNullableBoolean(isPublic)
            )
        }
    }

}
