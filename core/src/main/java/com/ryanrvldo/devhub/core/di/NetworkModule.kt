package com.ryanrvldo.devhub.core.di

import com.google.gson.GsonBuilder
import com.ryanrvldo.devhub.core.BuildConfig
import com.ryanrvldo.devhub.core.data.source.remote.network.ApiService
import com.ryanrvldo.devhub.core.data.source.remote.network.LoginService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(120, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
        .build()

    @Provides
    @Singleton
    fun provideRetrofitBuilder(client: OkHttpClient): Retrofit.Builder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(client)


    @Provides
    @Singleton
    fun provideApiService(
        retrofitBuilder: Retrofit.Builder,
    ): ApiService = retrofitBuilder.baseUrl(BuildConfig.BASE_API_URL)
        .build()
        .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideLoginService(
        retrofitBuilder: Retrofit.Builder,
    ): LoginService = retrofitBuilder.baseUrl(BuildConfig.BASE_LOGIN_URL)
        .build()
        .create(LoginService::class.java)

}
