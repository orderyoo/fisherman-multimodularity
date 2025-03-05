package com.example.data.db

import com.example.domain.model.News
import com.example.domain.model.NewsDetails

class NewsLocalDataSource(
    //private val newsDao: NewsDao
) {

    suspend fun getNews(): List<News> {
        TODO("Provide the return value")
    }

    suspend fun getNewsDetails(id: Int): NewsDetails {
        TODO("Provide the return value")
    }

    suspend fun saveNews(news: List<News>) {
        TODO("Provide the return value")
    }

    suspend fun saveNewsDetails(newsDetails: NewsDetails) {
        TODO("Provide the return value")
    }
}