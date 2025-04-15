package com.example.fisherman.ui.screens.mymaps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.domain.model.News
import com.example.domain.model.Scheme
import com.example.domain.usecase.GetAllSchemesByRegionCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
@HiltViewModel
class MyMapViewModel @Inject constructor(
    private val provideGetAllSchemesByRegionCase: Lazy<GetAllSchemesByRegionCase>
): ViewModel(){
    sealed interface State {
        data object Loading : State
        data class Success(val schemes: List<Scheme>) : State
        data class Error(val message: String) : State
    }

    private val _state = MutableStateFlow<State>(State.Loading)
    val state: StateFlow<State> = _state.asStateFlow()

    init {
        loadSchemas()
    }

    private fun loadSchemas(){
        viewModelScope.launch {
            provideGetAllSchemesByRegionCase
        }
    }


}*/