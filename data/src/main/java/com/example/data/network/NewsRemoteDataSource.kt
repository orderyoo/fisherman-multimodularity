package com.example.data.network

import com.example.domain.model.News
import com.example.domain.model.NewsDetails
import retrofit2.Response

class NewsRemoteDataSource(private val apiService: ApiService) {
    suspend fun getNews(ofSet: Int?, limit: Int?): Response<List<News>> {
        return apiService.getNews(ofSet, limit)
    }

    suspend fun getNewsDetails(id: String): Response<NewsDetails> {
        return apiService.getNewsDetails(id)
    }
}