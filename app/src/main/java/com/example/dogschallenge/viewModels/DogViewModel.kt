package com.example.dogschallenge.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogschallenge.repositories.CeoDogsRepository
import com.example.dogschallenge.services.CeoDogsApiFactory
import kotlinx.coroutines.launch

class DogViewModel(
    private val repository: CeoDogsRepository = CeoDogsRepository(CeoDogsApiFactory.create())
): ViewModel(){
    var state by  mutableStateOf(DogsState())
    init {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            repository.listBreeds().onSuccess {
                state = state.copy(breeds = it)
            }.onFailure {
               println()
            }
            state = state.copy(isLoading = false)
        }
    }
}