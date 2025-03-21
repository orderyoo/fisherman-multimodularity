package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.db.entities.NewsEntity

@Database(entities = [NewsEntity::class], version = 1)
abstract class NewsRoomDatabase: RoomDatabase() {
    abstract fun newsDAO() : NewsDao
}