package com.ryanrvldo.devhub.core.di

import com.ryanrvldo.devhub.core.domain.usecase.accesstoken.ReadUserAccessTokenUseCase
import com.ryanrvldo.devhub.core.domain.usecase.accesstoken.ReadUserAccessTokenUseCaseImpl
import com.ryanrvldo.devhub.core.domain.usecase.accesstoken.WriteUserAccessTokenUseCase
import com.ryanrvldo.devhub.core.domain.usecase.accesstoken.WriteUserAccessTokenUseCaseImpl
import com.ryanrvldo.devhub.core.domain.usecase.login.CheckUserLoginStatusUseCase
import com.ryanrvldo.devhub.core.domain.usecase.login.CheckUserLoginStatusUseCaseImpl
import com.ryanrvldo.devhub.core.domain.usecase.login.LoginUseCase
import com.ryanrvldo.devhub.core.domain.usecase.login.LoginUseCaseImpl
import com.ryanrvldo.devhub.core.domain.usecase.user.GetUserDetailsUseCase
import com.ryanrvldo.devhub.core.domain.usecase.user.GetUserDetailsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule::class])
abstract class UseCaseModule {

    @Binds
    abstract fun providePutUserTokenUseCase(putUserTokenUseCaseImpl: WriteUserAccessTokenUseCaseImpl): WriteUserAccessTokenUseCase

    @Binds
    abstract fun provideGetUserTokenUseCase(getUserTokenUseCaseImpl: ReadUserAccessTokenUseCaseImpl): ReadUserAccessTokenUseCase

    @Binds
    abstract fun provideCheckUserLoginStatusUseCase(checkUserLoginStatusUseCaseImpl: CheckUserLoginStatusUseCaseImpl): CheckUserLoginStatusUseCase

    @Binds
    abstract fun provideLoginUseCase(loginUseCaseImpl: LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun provideGetUserDetailsUseCase(getUserDetailsUseCaseImpl: GetUserDetailsUseCaseImpl): GetUserDetailsUseCase

//    @Binds
//    abstract fun provideSearchUseCase(searchUseCaseImpl: SearchUseCaseImpl): SearchUseCase

}
