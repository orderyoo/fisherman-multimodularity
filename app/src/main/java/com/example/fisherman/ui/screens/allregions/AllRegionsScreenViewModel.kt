package com.example.fisherman.ui.screens.allregions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Region
import com.example.domain.usecase.GetAllRegionsCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.Lazy

@HiltViewModel
class AllRegionsScreenViewModel @Inject constructor(
    private val provideGetAllRegionUseCase : Lazy<GetAllRegionsCase>
) : ViewModel() {

    sealed interface State{
        data object Loading : State
        data class Success(val regions: List<Region>) : State
        data class Error(val message: String) : State
    }

    private val _state = MutableStateFlow<State>(State.Loading)
    val state: StateFlow<State> = _state.asStateFlow()

    init {
        loadAllRegions()
    }

    private fun loadAllRegions(){
        viewModelScope.launch {
            provideGetAllRegionUseCase.get().invoke().onSuccess { value: List<Region> ->
                _state.value = State.Success(value)
            }.onFailure { exception ->
                _state.value = State.Error(exception.message?: "Unknown error occurred")
            }
        }
    }


}