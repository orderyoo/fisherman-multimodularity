package com.example.domain.usecase

import com.example.domain.model.NewsDetails
import com.example.domain.repository.NewsRepository

class GetNewsDetailsCase(private val newsRepository: NewsRepository) {
    suspend fun execute(id: String): Result<NewsDetails> {
        return try {
            Result.success(newsRepository.getNewsDetails(id))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}