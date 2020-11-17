package com.ryanrvldo.devhub.core.domain.usecase.accesstoken

import com.ryanrvldo.devhub.core.data.Resource

interface ReadUserAccessTokenUseCase {

    fun readAccessToken(): Resource<String>

}
