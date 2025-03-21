package com.example.fisherman.ui.screens.additionaloptions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.News
import com.example.domain.usecase.GetOneLastNewsCase
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdditionalOptionsScreenViewModel @Inject constructor(
    private val provideGetOneLastNewsCase: Lazy<GetOneLastNewsCase>
): ViewModel() {

    private val _lastNew = MutableStateFlow<List<News>>(emptyList())
    val lastNew: StateFlow<List<News>> = _lastNew.asStateFlow()

    fun loadLastNew() {
        viewModelScope.launch {
            provideGetOneLastNewsCase.get()
            provideGetOneLastNewsCase.get().invoke().onSuccess { new ->
                _lastNew.value = new
            }.onFailure {
                TODO()
            }
        }
    }
}