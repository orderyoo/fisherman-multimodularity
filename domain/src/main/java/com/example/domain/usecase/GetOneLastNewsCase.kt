package com.example.domain.usecase

import com.example.domain.model.News
import com.example.domain.repository.NewsRepository

class GetOneLastNewsCase(private val repository: NewsRepository) {
    suspend fun execute(): Result<List<News>> {
        return try {
            Result.success(repository.getNews(null,1))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}