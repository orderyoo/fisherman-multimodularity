package com.example.data.repository

import com.example.data.db.LocalDataSource
import com.example.data.network.RemoteDataSource
import com.example.data.network.safeApiCall
import com.example.domain.model.News
import com.example.domain.model.NewsDetails
import com.example.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : NewsRepository {

    override suspend fun getNews(offset: Int?, limit: Int?): Result<List<News>> {
        val remoteNews = safeApiCall { remoteDataSource.getNews(offset, limit) }
        return remoteNews
    }

    override suspend fun getNewsDetails(id: String): Result<NewsDetails> {
        val remoteDataSource = safeApiCall { remoteDataSource.getNewsDetails(id) }
        return remoteDataSource
    }
}