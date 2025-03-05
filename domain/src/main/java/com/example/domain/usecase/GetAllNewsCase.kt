package com.example.domain.usecase

import com.example.domain.model.News
import com.example.domain.repository.NewsRepository

class GetAllNewsCase(private val newsRepository: NewsRepository){
    suspend fun execute(): Result<List<News>> {
        return try {
            Result.success(newsRepository.getNews(null,null))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}