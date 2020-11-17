package com.ryanrvldo.devhub.core.util.mapper.impl

import com.google.common.truth.Truth.assertThat
import com.ryanrvldo.devhub.core.data.DummyData
import com.ryanrvldo.devhub.core.data.source.remote.response.token.AccessTokenResponse
import com.ryanrvldo.devhub.core.domain.model.AccessToken
import com.ryanrvldo.devhub.core.util.mapper.ResponseToDomainMapperTest
import org.junit.Test

class AccessTokenResponseToDomainMapperTest : ResponseToDomainMapperTest {

    @Test
    override fun `test map null properties response returns domain model`() {
        val response = AccessTokenResponse(null, null, null)
        val result = AccessTokenResponseToDomainMapper.map(response)
        val expected = AccessToken("null", "null", "null")
        assertThat(result).isEqualTo(expected)
    }

    @Test
    override fun `test map non null properties response returns domain model`() {
        val response = AccessTokenResponse("accessToken", "tokenType", "scope")
        val result = AccessTokenResponseToDomainMapper.map(response)
        val expected = DummyData.getDummyAccessTokenDomain()
        assertThat(result).isEqualTo(expected)
    }

}
