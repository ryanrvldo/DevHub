package com.ryanrvldo.devhub.core.util.validation

object NullableValidationUtil {

    fun validateNullableString(string: String?): String {
        return string.toString()
    }

    fun validateNullableInteger(int: Int?): Int {
        return int ?: 0
    }

    fun validateNullableBoolean(boolean: Boolean?): Boolean {
        return boolean ?: false
    }

}
