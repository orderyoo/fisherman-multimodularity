package com.example.data.repository

import com.example.data.db.NewsLocalDataSource
import com.example.data.network.NewsRemoteDataSource
import com.example.domain.model.News
import com.example.domain.model.NewsDetails
import com.example.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val remoteDataSource: NewsRemoteDataSource,
    private val localDataSource: NewsLocalDataSource
) : NewsRepository {

    override suspend fun getNews(offset: Int?, limit: Int?): List<News> {
        val remoteNews = remoteDataSource.getNews(offset, limit)
        return remoteNews
    }

    override suspend fun getNewsDetails(id: String): NewsDetails {
        val remoteDataSource = remoteDataSource.getNewsDetails(id)
        return remoteDataSource
    }

    override suspend fun getLocalNews(): List<News> {
        return localDataSource.getNews()
    }

    override fun getNewsById(id: Int): News {
        return localDataSource.getNewsById(id)
    }

    override fun saveNews(news: List<News>) {
        localDataSource.saveNews(news)
    }

    override fun deleteNews(news: News) {
        localDataSource.deleteNews(news)
    }

    override suspend fun deleteAllNews() {
        localDataSource.deleteAllNews()
    }

}