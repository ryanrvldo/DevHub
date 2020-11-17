package com.ryanrvldo.devhub.core.di

import com.ryanrvldo.devhub.core.data.repository.LoginRepositoryImpl
import com.ryanrvldo.devhub.core.data.repository.SharedPrefRepositoryImpl
import com.ryanrvldo.devhub.core.data.repository.UserRepositoryImpl
import com.ryanrvldo.devhub.core.domain.repository.LoginRepository
import com.ryanrvldo.devhub.core.domain.repository.SharedPrefRepository
import com.ryanrvldo.devhub.core.domain.repository.UserRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, SharedPrefModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

    @Binds
    abstract fun provideSharedPrefRepository(sharedPrefRepositoryImpl: SharedPrefRepositoryImpl): SharedPrefRepository

    @Binds
    abstract fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

//    @Binds
//    abstract fun provideSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository

}
