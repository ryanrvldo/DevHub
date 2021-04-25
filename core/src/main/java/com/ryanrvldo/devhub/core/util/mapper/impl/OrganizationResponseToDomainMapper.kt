package com.ryanrvldo.devhub.core.util.mapper.impl

import com.ryanrvldo.devhub.core.data.source.remote.response.events.OrganizationResponse
import com.ryanrvldo.devhub.core.domain.model.events.Organization
import com.ryanrvldo.devhub.core.util.mapper.Mapper
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableInteger
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableString

object OrganizationResponseToDomainMapper : Mapper<OrganizationResponse?, Organization> {

    override fun map(input: OrganizationResponse?): Organization {
        input?.let { response ->
            return with(response) {
                Organization(
                    id = validateNullableInteger(id),
                    name = validateNullableString(name),
                    url = validateNullableString(url),
                    avatarUrl = validateNullableString(avatarUrl)
                )
            }
        } ?: return Organization(-1, "", "", "")
    }

}
