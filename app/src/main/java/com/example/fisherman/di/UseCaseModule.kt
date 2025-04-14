package com.example.fisherman.di

import com.example.domain.repository.NewsRepository
import com.example.domain.repository.SchemesRepository
import com.example.domain.usecase.GetAllNewsCase
import com.example.domain.usecase.GetAllRegionsCase
import com.example.domain.usecase.GetAllSchemesByNameCase
import com.example.domain.usecase.GetAllSchemesByRegionCase
import com.example.domain.usecase.GetNewsDetailsCase
import com.example.domain.usecase.GetOneLastNewsCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetOneLastNewsUseCase(newsRepository: NewsRepository): GetOneLastNewsCase {
        return GetOneLastNewsCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideGetAllNewsUseCase(newsRepository: NewsRepository): GetAllNewsCase {
        return GetAllNewsCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideGetNewsDetailsUseCase(newsRepository: NewsRepository): GetNewsDetailsCase {
        return GetNewsDetailsCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideGetAllSchemesByRegion(repository: SchemesRepository): GetAllSchemesByRegionCase{
        return GetAllSchemesByRegionCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAllSchemeByName(repository: SchemesRepository): GetAllSchemesByNameCase {
        return GetAllSchemesByNameCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAllRegionUseCase(repository: SchemesRepository): GetAllRegionsCase {
        return GetAllRegionsCase(repository)
    }
}