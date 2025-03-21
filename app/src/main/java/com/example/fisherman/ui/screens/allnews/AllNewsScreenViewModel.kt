package com.example.fisherman.ui.screens.allnews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.News
import com.example.domain.usecase.GetAllNewsCase
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllNewsScreenViewModel @Inject constructor(
    private val provideGetAllNewsCase: Lazy<GetAllNewsCase>,
): ViewModel() {

    sealed interface State {
        data object Loading : State
        data class Success(val news: List<News>) : State
        data class Error(val message: String) : State
    }

    private val _state = MutableStateFlow<State>(State.Loading)
    val state: StateFlow<State> = _state.asStateFlow()

    init {
        loadNewDetails()
    }

    private fun loadNewDetails() {
        viewModelScope.launch {
            provideGetAllNewsCase.get().invoke().onSuccess { news ->
                _state.value = State.Success(news)
            }.onFailure { exception ->
                _state.value = State.Error(exception.message?: "Unknown error occurred")
            }
        }
    }
}