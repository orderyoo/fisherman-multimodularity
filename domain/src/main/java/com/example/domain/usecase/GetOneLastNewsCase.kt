package com.example.domain.usecase

import com.example.domain.model.News
import com.example.domain.repository.NewsRepository

class GetOneLastNewsCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(): Result<List<News>> = newsRepository.getNews(null, 1)
}