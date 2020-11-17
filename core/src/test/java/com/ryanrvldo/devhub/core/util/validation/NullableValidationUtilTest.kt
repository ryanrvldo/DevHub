package com.ryanrvldo.devhub.core.util.validation

import com.google.common.truth.Truth.assertThat
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableBoolean
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableInteger
import com.ryanrvldo.devhub.core.util.validation.NullableValidationUtil.validateNullableString
import org.junit.Test

class NullableValidationUtilTest {

    @Test
    fun `test validate null string returns null`() {
        val result = validateNullableString(null)
        assertThat(result).isEqualTo("null")
    }

    @Test
    fun `test validate blank string returns blank string`() {
        val result = validateNullableString("")
        assertThat(result).isEqualTo("")
    }

    @Test
    fun `test validate whitespace string returns blank string`() {
        val result = validateNullableString("      ")
        assertThat(result).isEqualTo("      ")
    }

    @Test
    fun `test validate non null string returns string`() {
        val result = validateNullableString("string")
        assertThat(result).isEqualTo("string")
    }

    @Test
    fun `test validate null integer returns zero`() {
        val result = validateNullableInteger(null)
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `test validate non-null integer returns integer number`() {
        val result = validateNullableInteger(20000)
        assertThat(result).isEqualTo(20000)
    }

    @Test
    fun `test validate null boolean returns false`() {
        val result = validateNullableBoolean(null)
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `test validate non-null false boolean returns false`() {
        val result = validateNullableBoolean(false)
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `test validate non-null true boolean returns true`() {
        val result = validateNullableBoolean(true)
        assertThat(result).isEqualTo(true)
    }

}
