package com.example.meals.presentation.mealdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meals.core.Resource
import com.example.meals.domain.usecases.MealsDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(private val mealsDetailsUseCase: MealsDetailsUseCase): ViewModel(){
    private val _mealDetails = MutableStateFlow<PlayerDetailsState>(PlayerDetailsState())
    val mealDetails: StateFlow<PlayerDetailsState> = _mealDetails


    fun getMealDetails(i: String) {
        mealsDetailsUseCase(i).onEach {
            when (it) {
                is Resource.Loading -> {
                    _mealDetails.value = PlayerDetailsState(isLoading = true)
                }
                is Resource.Error -> {
                    _mealDetails.value = PlayerDetailsState(error = it.message ?: "")
                }
                is Resource.Success -> {
                    _mealDetails.value = PlayerDetailsState(data = it.data?.get(0))
                }
            }
        }.launchIn(viewModelScope)
    }
}