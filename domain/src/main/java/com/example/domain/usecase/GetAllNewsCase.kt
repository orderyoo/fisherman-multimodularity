package com.example.domain.usecase

import com.example.domain.model.News
import com.example.domain.repository.NewsRepository

class GetAllNewsCase(private val newsRepository: NewsRepository){
    suspend fun execute(): Result<List<News>> = newsRepository.getNews(null, null)
}