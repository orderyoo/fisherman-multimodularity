package com.example.domain.usecase

import com.example.domain.model.NewsDetails
import com.example.domain.repository.NewsRepository

class GetNewsDetailsCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(id: String): Result<NewsDetails> = newsRepository.getNewsDetails(id)
}