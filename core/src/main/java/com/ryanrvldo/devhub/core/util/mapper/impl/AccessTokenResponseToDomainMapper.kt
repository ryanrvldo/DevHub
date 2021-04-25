package com.ryanrvldo.devhub.core.util.mapper.impl

import com.ryanrvldo.devhub.core.data.source.remote.response.token.AccessTokenResponse
import com.ryanrvldo.devhub.core.domain.model.token.AccessToken
import com.ryanrvldo.devhub.core.util.mapper.Mapper
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableString

object AccessTokenResponseToDomainMapper : Mapper<AccessTokenResponse, AccessToken> {

    override fun map(input: AccessTokenResponse): AccessToken {
        return with(input) {
            AccessToken(
                accessToken = validateNullableString(accessToken),
                tokenType = validateNullableString(tokenType),
                scope = validateNullableString(scope)
            )
        }
    }

}
