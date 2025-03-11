package com.example.data.network

import com.example.domain.model.News
import com.example.domain.model.NewsDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/news")
    suspend fun getNews(
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): Response<List<News>>

    @GET("news_details")
    suspend fun getNewsDetails(
        @Query("news_id") newsId: String
    ): Response<NewsDetails>

}