package com.example.fisherman.di

import android.content.Context
import androidx.room.Room
import com.example.data.db.NewsDao
import com.example.data.db.LocalDataSource
import com.example.data.db.NewsRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomDatabaseModule {

    @Provides
    @Singleton
    fun providesLocalDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NewsRoomDatabase::class.java,
        "local-news"
    ).build()

    @Provides
    fun provideNewsDao(database: NewsRoomDatabase) = database.newsDAO()

    @Provides
    @Singleton
    fun provideNewsLocalDataSource(newsDao: NewsDao): LocalDataSource {
        return LocalDataSource(newsDao)
    }

}