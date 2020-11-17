package com.ryanrvldo.devhub.core.data.source.sharedpref

import android.content.SharedPreferences
import androidx.core.content.edit
import com.ryanrvldo.devhub.core.data.Resource
import com.ryanrvldo.devhub.core.util.Constants.SHARED_PREF_ERROR
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefDataSource @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) {

    fun putString(key: String, value: String) {
        sharedPreferences.edit {
            putString(key, value)
        }
    }

    fun getString(key: String): Resource<String> {
        val result = sharedPreferences.getString(key, "")
        result?.let {
            return if (result.isNotBlank()) {
                Resource.Success(result)
            } else {
                Resource.Error("Data is blank.")
            }
        } ?: return Resource.Error(SHARED_PREF_ERROR)
    }

    fun removeString(key: String) {
        sharedPreferences.edit(true) {
            remove(key)
        }
    }

}
