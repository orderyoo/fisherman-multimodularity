package com.example.domain.repository

import com.example.domain.model.News
import com.example.domain.model.NewsDetails

interface NewsRepository {
    suspend fun getNews(offset: Int?, limit: Int?): List<News>
    suspend fun getNewsDetails(id: String): NewsDetails

    //???
    suspend fun getLocalNews(): List<News>

    fun getNewsById(id: Int): News

    fun saveNews(news: List<News>)

    fun deleteNews(news: News)

    suspend fun deleteAllNews()
}