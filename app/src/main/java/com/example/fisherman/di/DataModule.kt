package com.example.fisherman.di

import com.example.data.db.NewsDao
import com.example.data.network.ApiService
import com.example.data.network.NewsRemoteDataSource
import com.example.data.db.NewsLocalDataSource
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


    @Provides
    @Singleton
    fun provideNewsLocalDataSource(newsDao: NewsDao): NewsLocalDataSource {
        return NewsLocalDataSource(newsDao)
    }
}