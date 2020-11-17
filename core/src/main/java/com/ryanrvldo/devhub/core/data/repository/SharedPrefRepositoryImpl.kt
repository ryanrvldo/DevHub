package com.ryanrvldo.devhub.core.data.repository

import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.data.source.sharedpref.SharedPrefDataSource
import com.ryanrvldo.devhub.core.domain.repository.SharedPrefRepository
import com.ryanrvldo.devhub.core.util.Constants.USER_TOKEN_KEY
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefRepositoryImpl @Inject constructor(
    private val sharedPrefDataSource: SharedPrefDataSource,
) : SharedPrefRepository {

    override fun putUserToken(value: String) {
        sharedPrefDataSource.putString(USER_TOKEN_KEY, value)
    }

    override fun getUserToken(): Resource<String> {
        return sharedPrefDataSource.getString(USER_TOKEN_KEY)
    }

    override fun removeUserToken() {
        return sharedPrefDataSource.removeString(USER_TOKEN_KEY)
    }

}
