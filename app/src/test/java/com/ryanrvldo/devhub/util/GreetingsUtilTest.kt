package com.ryanrvldo.devhub.util

import android.content.Context
import com.google.common.truth.Truth.assertThat
import com.ryanrvldo.devhub.R
import com.ryanrvldo.devhub.core.util.GreetingsUtil
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GreetingsUtilTest {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun `test greetings return string from resource`() {
        `when`(mockContext.getString(R.string.good_afternoon)).thenReturn(FAKE_GREETINGS)
        val result = GreetingsUtil.getGreetings(mockContext)
        assertThat(result).isEqualTo(FAKE_GREETINGS)
    }

    companion object {
        private const val FAKE_GREETINGS = "Good Afternoon"
    }

}
