package com.ryanrvldo.devhub.core.di

import android.content.Context
import android.content.SharedPreferences
import com.ryanrvldo.devhub.core.util.Constants.TOKEN_SHARED_PREF
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPrefModule {

    @Provides
    @Singleton
    fun provideTokenSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(TOKEN_SHARED_PREF, Context.MODE_PRIVATE)
    }

}
