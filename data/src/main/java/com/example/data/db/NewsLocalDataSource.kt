package com.example.data.db

import com.example.data.mapper.toNews
import com.example.data.mapper.toNewsEntity
import com.example.domain.model.News
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class NewsLocalDataSource(
    private val newsDao: NewsDao
) {

    suspend fun getNews(): List<News> {
        return newsDao.getNews().map { newsEntityList ->
            newsEntityList.map { newsEntity -> newsEntity.toNews() }
        }.first()
    }

    fun getNewsById(id: Int) : News {
        val news = newsDao.getNewsById(id)
        return news.toNews()
    }

    fun saveNews(news: List<News>) {
        newsDao.insertNews(news.map { it.toNewsEntity() })
    }

    fun deleteNews(news: News){
        newsDao.delete(news.toNewsEntity())
    }

    suspend fun deleteAllNews(){
        newsDao.deleteAllNews()
    }
}