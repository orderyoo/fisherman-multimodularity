package com.example.fisherman.di

import com.example.data.network.ApiService
import com.example.data.network.NewsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideNewsRemoteDataSource(apiService: ApiService): NewsRemoteDataSource {
        return NewsRemoteDataSource(apiService)
    }

}