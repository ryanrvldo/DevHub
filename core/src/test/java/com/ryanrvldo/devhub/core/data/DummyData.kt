package com.ryanrvldo.devhub.core.data

import com.ryanrvldo.devhub.core.data.source.remote.network.ApiResponse
import com.ryanrvldo.devhub.core.data.source.remote.response.token.AccessTokenResponse
import com.ryanrvldo.devhub.core.domain.model.token.AccessToken

object DummyData {

    fun getDummyAccessTokenDomain(): AccessToken = AccessToken("accessToken", "tokenType", "scope")

    fun getDummyAccessTokenResponse(): AccessTokenResponse =
        AccessTokenResponse("accessToken", "tokenType", "scope")

    fun getDummySuccessApiResponse(): ApiResponse<AccessTokenResponse> = ApiResponse.Success(
        getDummyAccessTokenResponse()
    )

    fun getDummyEmptyApiResponse(): ApiResponse<Nothing> = ApiResponse.Empty

    fun getDummyErrorApiResponse(): ApiResponse<AccessTokenResponse> =
        ApiResponse.Error("Network exception.")

    fun getDummyAccessTokenSharedPref() = "token"

}
