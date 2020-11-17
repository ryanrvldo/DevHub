package com.ryanrvldo.devhub.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AccessToken(
    val accessToken: String,
    val tokenType: String,
    val scope: String,
) : Parcelable
