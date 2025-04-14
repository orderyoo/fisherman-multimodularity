package com.example.data.network

import com.example.domain.model.News
import com.example.domain.model.NewsDetails
import com.example.domain.model.Region
import com.example.domain.model.Scheme
import retrofit2.Response

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getNews(ofSet: Int?, limit: Int?): Response<List<News>> {
        return apiService.getNews(ofSet, limit)
    }

    suspend fun getNewsDetails(id: String): Response<NewsDetails> {
        return apiService.getNewsDetails(id)
    }

    suspend fun getAllSchemesByRegion(token: String?): Response<Scheme> {
        return apiService.getAllSchemesByRegion(token)
    }

    suspend fun getSchemeByName(name: String): Response<Scheme> {
        return apiService.getSchemeByName(name)
    }

    suspend fun getAllRegions(): Response<Region> {
        return apiService.getRegion()
    }
}