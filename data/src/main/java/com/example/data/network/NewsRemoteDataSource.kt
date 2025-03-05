package com.example.data.network

import com.example.domain.model.News
import com.example.domain.model.NewsDetails

class NewsRemoteDataSource(private val apiService: ApiService) {
    suspend fun getNews(ofSet: Int?, limit: Int?): List<News> {
        return apiService.getNews(ofSet, limit)
    }

    suspend fun getNewsDetails(id: String): NewsDetails {
        return apiService.getNewsDetails(id)
    }
}