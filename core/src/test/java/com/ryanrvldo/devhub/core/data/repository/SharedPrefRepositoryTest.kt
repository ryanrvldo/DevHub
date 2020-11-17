package com.ryanrvldo.devhub.core.data.repository

import android.content.SharedPreferences
import com.google.common.truth.Truth.assertThat
import com.ryanrvldo.devhub.core.data.DummyData
import com.ryanrvldo.devhub.core.data.source.sharedpref.SharedPrefDataSource
import com.ryanrvldo.devhub.core.domain.repository.SharedPrefRepository
import com.ryanrvldo.devhub.core.util.Constants.USER_TOKEN_KEY
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SharedPrefRepositoryTest {

    private val accessTokenDummy = DummyData.getDummyAccessTokenSharedPref()

    private lateinit var sharedPrefDataSource: SharedPrefDataSource
    private lateinit var brokenSharedPrefDataSource: SharedPrefDataSource

    private lateinit var sharedPrefRepository: SharedPrefRepository
    private lateinit var brokenSharedPrefRepository: SharedPrefRepository

    @field:Mock
    lateinit var mockedSharedPref: SharedPreferences

    @field:Mock
    lateinit var mockedEditor: SharedPreferences.Editor

    @field:Mock
    lateinit var mockedBrokenSharedPref: SharedPreferences

    @field:Mock
    lateinit var mockedBrokenEditor: SharedPreferences.Editor

    @Before
    fun setUp() {
        sharedPrefDataSource = createMockSharedPref()
        sharedPrefRepository = SharedPrefRepositoryImpl(sharedPrefDataSource)

        brokenSharedPrefDataSource = createBrokenMockSharedPref()
        brokenSharedPrefRepository = SharedPrefRepositoryImpl(brokenSharedPrefDataSource)
    }


    @Test
    fun `test successful write and read string shared pref`() {
        sharedPrefRepository.putUserToken(accessTokenDummy)
        val result = sharedPrefRepository.getUserToken()
        val dataResult = result.data!!
        assertThat(dataResult).isEqualTo(accessTokenDummy)
    }

    @Test
    fun `test write and failed read string shared pref`() {
        brokenSharedPrefRepository.removeUserToken()
        val result = brokenSharedPrefRepository.getUserToken()
        val resultData = result.data
        assertThat(resultData).isNull()
    }

    private fun createMockSharedPref(): SharedPrefDataSource {
        `when`(mockedSharedPref.getString(eq(USER_TOKEN_KEY), anyString()))
            .thenReturn(accessTokenDummy)

        `when`(mockedSharedPref.edit()).thenReturn(mockedEditor)

        return SharedPrefDataSource(mockedSharedPref)
    }

    private fun createBrokenMockSharedPref(): SharedPrefDataSource {
        `when`(mockedBrokenSharedPref.getString(eq(USER_TOKEN_KEY), anyString()))
            .thenReturn(null)

        `when`(mockedBrokenSharedPref.edit()).thenReturn(mockedBrokenEditor)

        return SharedPrefDataSource(mockedBrokenSharedPref)
    }
}
