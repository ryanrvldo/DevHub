package com.ryanrvldo.devhub.core.util

import com.ryanrvldo.devhub.core.BuildConfig

object Constants {

    const val GITHUB_LOGIN_URL = "${BuildConfig.BASE_LOGIN_URL}authorize" +
            "?client_id=${BuildConfig.CLIENT_ID}" +
            "&scope=user%20repo%20delete_repo%20gist%20notifications" +
            "&redirect_uri=${BuildConfig.CALLBACK_URL}"

    const val TOKEN_EXTRA = "EXTRA_TOKEN"

    const val TOKEN_SHARED_PREF = "com.ryanrvldo.devhub.TOKEN_SHARED_PREF"
    const val USER_TOKEN_KEY = "com.ryanrvldo.devhub.USER_TOKEN_KEY"
    const val SHARED_PREF_ERROR = "ERROR_SHARED_PREFERENCES"
}
