package com.ryanrvldo.devhub.core.domain.usecase.login

import com.ryanrvldo.devhub.core.data.Resource

interface CheckUserLoginStatusUseCase {

    fun checkStatus(): Resource<Boolean>

}
