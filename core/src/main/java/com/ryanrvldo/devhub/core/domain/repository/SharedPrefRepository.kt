package com.ryanrvldo.devhub.core.domain.repository

import com.ryanrvldo.devhub.core.data.Resource

interface SharedPrefRepository {

    fun putUserToken(value: String)

    fun getUserToken(): Resource<String>

    fun removeUserToken()

}
