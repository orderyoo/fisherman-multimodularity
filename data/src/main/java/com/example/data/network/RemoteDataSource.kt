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

    suspend fun getAllSchemesByRegion(water_id : String, token: String?): Response<List<Scheme>> {
        return apiService.getAllSchemesByRegion(water_id, token)
    }

    suspend fun getSchemeByName(name: String): Response<List<Scheme>> {
        return apiService.getSchemeByName(name)
    }

    suspend fun getAllRegions(): Response<List<Region>> {
        return apiService.getRegion()
    }
}