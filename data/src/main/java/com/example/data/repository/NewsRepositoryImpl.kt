package com.example.data.repository

import com.example.data.db.NewsLocalDataSource
import com.example.data.network.NewsRemoteDataSource
import com.example.data.network.safeApiCall
import com.example.domain.model.News
import com.example.domain.model.NewsDetails
import com.example.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val remoteDataSource: NewsRemoteDataSource,
    private val localDataSource: NewsLocalDataSource
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