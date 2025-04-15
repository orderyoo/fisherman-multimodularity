package com.example.data.network

import com.example.domain.model.News
import com.example.domain.model.NewsDetails
import com.example.domain.model.Region
import com.example.domain.model.Scheme
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/api/news")
    suspend fun getNews(
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): Response<List<News>>

    @GET("/api/news/{news_id}")
    suspend fun getNewsDetails(
        @Path("news_id") newsId: String
    ): Response<NewsDetails>

    @GET("/api/water/{water_id}/schemes")
    suspend fun getAllSchemesByRegion(
        @Query("Authorization") token: String?
    ): Response<List<Scheme>>

    @GET("api/schemes/search")
    suspend fun getSchemeByName(
        @Query("name") name: String
    ): Response<List<Scheme>>

    @GET("/api/waters")
    suspend fun getRegion(): Response<List<Region>>

}