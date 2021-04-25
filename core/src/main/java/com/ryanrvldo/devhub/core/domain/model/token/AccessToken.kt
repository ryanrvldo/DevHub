package com.ryanrvldo.devhub.core.domain.model.token

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AccessToken(
    val accessToken: String,
    val tokenType: String,
    val scope: String,
) : Parcelable
