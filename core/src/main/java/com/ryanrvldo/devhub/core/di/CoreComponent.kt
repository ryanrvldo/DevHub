package com.ryanrvldo.devhub.core.di

import android.content.Context
import com.ryanrvldo.devhub.core.domain.usecase.accesstoken.ReadUserAccessTokenUseCase
import com.ryanrvldo.devhub.core.domain.usecase.accesstoken.WriteUserAccessTokenUseCase
import com.ryanrvldo.devhub.core.domain.usecase.login.CheckUserLoginStatusUseCase
import com.ryanrvldo.devhub.core.domain.usecase.login.LoginUseCase
import com.ryanrvldo.devhub.core.domain.usecase.user.GetUserDetailsUseCase
import com.ryanrvldo.devhub.core.domain.usecase.user.GetUserReceivedEventsUseCase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UseCaseModule::class])
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun loginUseCase(): LoginUseCase

    fun writeUserAccessTokenUseCase(): WriteUserAccessTokenUseCase

    fun readUserAccessTokenUseCase(): ReadUserAccessTokenUseCase

    fun checkUserLoginStatusUseCase(): CheckUserLoginStatusUseCase

    fun getUserDetailsUseCase(): GetUserDetailsUseCase

    fun getUserReceivedEventsUseCase(): GetUserReceivedEventsUseCase

//    fun searchUseCase(): SearchUseCase

}
