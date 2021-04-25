package com.ryanrvldo.devhub.core.util.mapper.impl

import com.ryanrvldo.devhub.core.data.source.remote.response.events.ActorResponse
import com.ryanrvldo.devhub.core.domain.model.events.Actor
import com.ryanrvldo.devhub.core.util.mapper.Mapper
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableInteger
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableString

object ActorResponseToDomainMapper : Mapper<ActorResponse?, Actor> {

    override fun map(input: ActorResponse?): Actor {
        input?.let { response ->
            return with(response) {
                Actor(
                    id = validateNullableInteger(id),
                    username = validateNullableString(username),
                    url = validateNullableString(url),
                    avatarUrl = validateNullableString(avatarUrl)
                )
            }
        } ?: return Actor(-1, "", "", "")
    }
}
