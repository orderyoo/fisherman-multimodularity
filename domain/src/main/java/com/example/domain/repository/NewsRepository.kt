package com.example.domain.repository

import com.example.domain.model.News
import com.example.domain.model.NewsDetails

interface NewsRepository {
    suspend fun getNews(offset: Int?, limit: Int?): List<News>
    suspend fun getNewsDetails(id: String): NewsDetails
}