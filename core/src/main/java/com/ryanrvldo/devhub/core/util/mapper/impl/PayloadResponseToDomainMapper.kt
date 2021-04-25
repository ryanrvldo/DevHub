package com.ryanrvldo.devhub.core.util.mapper.impl

import com.ryanrvldo.devhub.core.data.source.remote.response.events.PayloadResponse
import com.ryanrvldo.devhub.core.domain.model.events.ForkEvent
import com.ryanrvldo.devhub.core.domain.model.events.Owner
import com.ryanrvldo.devhub.core.domain.model.events.Payload
import com.ryanrvldo.devhub.core.util.mapper.Mapper
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableString

object PayloadResponseToDomainMapper : Mapper<PayloadResponse?, Payload> {

    private val dummyOwner by lazy {
        Owner("", -1, "", "", "", "")
    }
    private val dummyForkEvent by lazy {
        ForkEvent(-1, "", "", "", dummyOwner, "", "", "")
    }

    override fun map(input: PayloadResponse?): Payload {
        input?.let { response ->
            return with(response) {
                Payload(
                    action = validateNullableString(action),
                    refType = validateNullableString(refType),
                    masterBranch = validateNullableString(masterBranch),
                    description = validateNullableString(description),
                    pusherType = validateNullableString(pusherType),
                    forkEvent = ForkEventResponseToDomainMapper.map(forkEventResponse),
                )
            }
        } ?: return Payload("", "", "", "", "",
            dummyForkEvent)
    }

}
