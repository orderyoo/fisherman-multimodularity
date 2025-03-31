package com.example.data.db

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

    suspend fun deleteAndSaveNews(news: List<News>){
        val newsEntities = news.map { it.toNewsEntity() }
        newsDao.deleteAndSaveNews(newsEntities)
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