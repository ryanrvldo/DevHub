package com.ryanrvldo.devhub.core.util.mapper.impl

import com.ryanrvldo.devhub.core.data.source.remote.response.events.RepoResponse
import com.ryanrvldo.devhub.core.domain.model.events.Repo
import com.ryanrvldo.devhub.core.util.mapper.Mapper
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableInteger
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableString

object RepoResponseToDomainMapper : Mapper<RepoResponse?, Repo> {

    override fun map(input: RepoResponse?): Repo {
        input?.let { response ->
            return with(response) {
                Repo(
                    id = validateNullableInteger(id),
                    name = validateNullableString(name),
                    url = validateNullableString(url)
                )
            }
        } ?: return Repo(-1, "", "")
    }
}
