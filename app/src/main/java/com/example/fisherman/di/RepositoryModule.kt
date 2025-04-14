package com.example.fisherman.di

import com.example.data.db.LocalDataSource
import com.example.data.network.RemoteDataSource
import com.example.data.repository.NewsRepositoryImpl
import com.example.data.repository.RegionRepositoryImpl
import com.example.domain.repository.NewsRepository
import com.example.domain.repository.RegionRepository
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
    fun provideNewsRepository(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource): NewsRepository {
        return NewsRepositoryImpl(remoteDataSource, localDataSource)
    }

    @Provides
    @Singleton
    fun provideRegionRepository(remoteDataSource: RemoteDataSource): RegionRepository {
        return RegionRepositoryImpl(remoteDataSource)
    }

}