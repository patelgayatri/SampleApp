package com.techand.sampleapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.techand.sampleapp.data.network.ApiService
import com.techand.sampleapp.data.network.BASE_URL
import com.techand.sampleapp.data.repository.UserInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideNewsService(retrofit: Retrofit) : ApiService =retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: ApiService) =
        UserInfoRepository(remoteDataSource)
}