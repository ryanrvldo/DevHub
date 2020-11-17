package com.ryanrvldo.devhub.core.util.mapper.impl

import com.google.common.truth.Truth.assertThat
import com.ryanrvldo.devhub.core.data.source.remote.response.profile.UserPlanResponse
import com.ryanrvldo.devhub.core.domain.model.UserPlan
import com.ryanrvldo.devhub.core.util.mapper.ResponseToDomainMapperTest
import org.junit.Test

class UserPlanResponseToDomainMapperTest : ResponseToDomainMapperTest {

    @Test
    override fun `test map null properties response returns domain model`() {
        val response = UserPlanResponse(null, null, null, null)
        val result = UserPlanResponseToDomainMapper.map(response)
        val expected = UserPlan("null", 0, 0, 0)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    override fun `test map non null properties response returns domain model`() {
        val response = UserPlanResponse("name", 1998, 1998, 1998)
        val result = UserPlanResponseToDomainMapper.map(response)
        val expected = UserPlan("name", 1998, 1998, 1998)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `test null response return default domain model`() {
        val result = UserPlanResponseToDomainMapper.map(null)
        val expected = UserPlan("", -1, -1, -1)
        assertThat(result).isEqualTo(expected)
    }

}
