package com.example.fisherman.di

import com.example.data.network.NewsRemoteDataSource
import com.example.data.repository.NewsRepositoryImpl
import com.example.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(remoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(remoteDataSource)
    }

}