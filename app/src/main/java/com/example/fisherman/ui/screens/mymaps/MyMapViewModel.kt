package com.example.fisherman.ui.screens.mymaps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Scheme
import com.example.domain.usecase.GetAllSchemesByRegionCase
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyMapViewModel @Inject constructor(
    private val provideGetAllSchemesByRegion: Lazy<GetAllSchemesByRegionCase>
): ViewModel(){
    sealed interface State {
        data object Loading : State
        data class Success(val schemes: List<Scheme>) : State
        data class Error(val message: String) : State
    }

    private val _state = MutableStateFlow<State>(State.Loading)
    val state: StateFlow<State> = _state.asStateFlow()

    init {
        //loadSchemas("1")
    }
/*
    private fun loadSchemas(token: String){
        viewModelScope.launch {
            provideGetAllSchemesByRegion.get().invoke(token).onSuccess{ schemes ->
                _state.value = State.Success(schemes)
            }.onFailure{ exception ->
                _state.value = State.Error(exception.message ?: "Unknown error occurred")
            }
        }
    }
 */
}