package com.example.fisherman.ui.screens.newsdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.NewsDetails
import com.example.domain.usecase.GetNewsDetailsCase
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailsScreenViewModel @Inject constructor(
    private val provideGetNewsDetailsCase: Lazy<GetNewsDetailsCase>,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    sealed interface State {
        data object Loading : State
        data class Success(val news: NewsDetails) : State
        data class Error(val message: String) : State
    }

    private val _state = MutableStateFlow<State>(State.Loading)
    val state: StateFlow<State> = _state.asStateFlow()

    init {
        val newsId = savedStateHandle.get<String>("newsId")
            ?: throw IllegalArgumentException("newsId is required")
        loadNewDetails(newsId)
    }

    fun loadNewDetails(id: String) {
        viewModelScope.launch {
            provideGetNewsDetailsCase.get().invoke(id).onSuccess { news ->
                _state.value = State.Success(news)
            }.onFailure { exception ->
                _state.value = State.Error(exception.message?: "Unknown error occurred")
            }
        }
    }
}