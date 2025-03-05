package com.example.fisherman.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.News
import com.example.domain.usecase.GetAllNewsCase
import com.example.domain.usecase.GetOneLastNewsCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestVM @Inject constructor(
    private val getAllNewsCase: GetAllNewsCase,
    private val getOneLastNewsCase: GetOneLastNewsCase
) : ViewModel() {

    private val _newsState = MutableStateFlow<List<News>>(emptyList())
    val newsState: StateFlow<List<News>> = _newsState.asStateFlow()

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?> = _errorState.asStateFlow()

    fun loadNews() {
        viewModelScope.launch {
            val result = getAllNewsCase.execute()
            result.onSuccess { news ->
                _newsState.value = news
            }.onFailure { error ->
                _errorState.value = error.message ?: "Unknown error"
            }
        }
    }
    fun loadNews1() {
        viewModelScope.launch {
            val result = getOneLastNewsCase.execute()
            result.onSuccess { news ->
                println(news[0].publicationDate)
                _newsState.value = news
            }.onFailure { error ->
                _errorState.value = error.message ?: "Unknown error"
            }
        }
    }
}