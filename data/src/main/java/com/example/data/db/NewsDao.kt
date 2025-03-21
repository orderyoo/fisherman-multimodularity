package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import com.example.data.db.entities.NewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM NewsEntity")
    fun getNews() : Flow<List<NewsEntity>>
    @Insert
    fun insertNews(news: List<NewsEntity>)
    @Query("SELECT * FROM NewsEntity WHERE id=:id")
    fun getNewsById(id: Int) : NewsEntity
    @Delete
    fun delete(news: NewsEntity)
    @Query("DELETE FROM NewsEntity")
    suspend fun deleteAllNews()

}