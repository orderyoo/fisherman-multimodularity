package com.example.fisherman.ui.screens.allmaps

import androidx.lifecycle.SavedStateHandle
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
class AllMapsScreenViewModel @Inject constructor(
    private val provideGetAllSchemesByRegionCase: Lazy<GetAllSchemesByRegionCase>,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

    sealed interface State{
        data object Loading : State
        data class Success(val maps: List<Scheme>) : State
        data class Error(val message: String) : State
    }

    private val _state = MutableStateFlow<State>(State.Loading)
    val state : StateFlow<State> = _state.asStateFlow()

    init {
        val water_id = savedStateHandle.get<String>("water_id")
            ?: throw IllegalArgumentException("water_id is required")
        loadAllMaps(water_id)
    }

    fun loadAllMaps(water_id : String){
        println(water_id)
        viewModelScope.launch {
            provideGetAllSchemesByRegionCase.get().invoke(water_id, token = null).onSuccess { maps ->
                _state.value = State.Success(maps)
            }.onFailure { exception ->
                _state.value = State.Error(exception.message?: "Unknown error occurred")
            }
        }
    }
}