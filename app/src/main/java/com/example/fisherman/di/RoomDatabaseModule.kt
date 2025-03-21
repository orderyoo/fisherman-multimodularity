package com.example.fisherman.di

import android.content.Context
import androidx.room.Room
import com.example.data.db.NewsLocalDataSource
import com.example.data.db.NewsRoomDatabase
import com.example.data.repository.NewsRepositoryImpl
import com.example.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RoomDatabaseModule{

    @Provides
    fun provideNewsDao(database: NewsRoomDatabase) = database.newsDAO()

    @Provides
    @Singleton
    fun providesLocalDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NewsRoomDatabase::class.java,
        "local-news"
    ).build()
}