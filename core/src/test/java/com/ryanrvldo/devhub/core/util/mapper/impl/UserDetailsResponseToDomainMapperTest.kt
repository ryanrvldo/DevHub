package com.ryanrvldo.devhub.core.util.mapper.impl

import com.google.common.truth.Truth
import com.ryanrvldo.devhub.core.data.source.remote.response.profile.UserDetailsResponse
import com.ryanrvldo.devhub.core.data.source.remote.response.profile.UserPlanResponse
import com.ryanrvldo.devhub.core.domain.model.profile.UserDetails
import com.ryanrvldo.devhub.core.domain.model.profile.UserPlan
import com.ryanrvldo.devhub.core.util.mapper.ResponseToDomainMapperTest
import org.junit.Test

class UserDetailsResponseToDomainMapperTest : ResponseToDomainMapperTest {

    @Test
    override fun `test map null properties response returns domain model`() {
        val response = UserDetailsResponse(null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )
        val result = UserDetailsResponseToDomainMapper.map(response)
        val expected = UserDetails(
            "null",
            0,
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            false,
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            0,
            0,
            0,
            0,
            "null",
            "null",
            0,
            0,
            0,
            0,
            0,
            false,
            UserPlan("", -1, -1, -1)
        )
        Truth.assertThat(result).isEqualTo(expected)
    }

    @Test
    override fun `test map non null properties response returns domain model`() {
        val response = UserDetailsResponse(null,
            1,
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            true,
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            1,
            1,
            1,
            1,
            "null",
            "null",
            1,
            1,
            1,
            1,
            1,
            true,
            UserPlanResponse("name", 1, 1, 1)
        )
        val result = UserDetailsResponseToDomainMapper.map(response)
        val expected = UserDetails(
            "null",
            1,
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            true,
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            "null",
            1,
            1,
            1,
            1,
            "null",
            "null",
            1,
            1,
            1,
            1,
            1,
            true,
            UserPlan("name", 1, 1, 1)

        )
        Truth.assertThat(result).isEqualTo(expected)
    }

}
