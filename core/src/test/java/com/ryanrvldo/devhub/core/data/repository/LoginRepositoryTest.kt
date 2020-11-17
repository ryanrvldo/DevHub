package com.ryanrvldo.devhub.core.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.ryanrvldo.devhub.core.MainCoroutinesRule
import com.ryanrvldo.devhub.core.data.DummyData
import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.data.repository.fake.FakeLoginRepository
import com.ryanrvldo.devhub.core.domain.model.AccessToken
import com.ryanrvldo.devhub.core.domain.repository.LoginRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class LoginRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutinesRule()

    private lateinit var loginRepository: LoginRepository
    private lateinit var accessToken: AccessToken

    @Before
    fun setUp() {
        loginRepository = FakeLoginRepository()
        accessToken = DummyData.getDummyAccessTokenDomain()
    }

    @Test
    fun `test flow emits returns loading resource class`() = runBlockingTest {
        val result = loginRepository.getAccessToken("code").first()
        assertThat(result).isInstanceOf(Resource.Loading<AccessToken>().javaClass)
    }

    @Test
    fun `test flow emits returns success resource class`() = runBlockingTest {
        val result = loginRepository.getAccessToken("code")
            .take(2)
            .toList()
        assertThat(result.first()).isInstanceOf(Resource.Loading<AccessToken>().javaClass)
        assertThat(result.last()).isInstanceOf(Resource.Success(accessToken).javaClass)
        assertThat(result.last().data).isEqualTo(accessToken)
    }

    @Test
    fun `test flow emits empty response returns error resource class`() = runBlockingTest {
        FakeLoginRepository.apiResponse = DummyData.getDummyEmptyApiResponse()
        val result = loginRepository.getAccessToken("code")
            .take(2)
            .toList()
        assertThat(result.first()).isInstanceOf(Resource.Loading<AccessToken>().javaClass)
        assertThat(result.last()).isInstanceOf(Resource.Error<AccessToken>("Null responses from server.").javaClass)
        assertThat(result.last().data).isEqualTo(null)
    }

    @Test
    fun `test flow emits error response returns error resource class`() = runBlockingTest {
        FakeLoginRepository.apiResponse = DummyData.getDummyErrorApiResponse()
        val result = loginRepository.getAccessToken("code")
            .take(2)
            .toList()
        assertThat(result.first()).isInstanceOf(Resource.Loading<AccessToken>().javaClass)
        assertThat(result.last()).isInstanceOf(Resource.Error<AccessToken>("Network exception").javaClass)
        assertThat(result.last().data).isEqualTo(null)
    }
}
