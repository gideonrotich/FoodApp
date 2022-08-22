package com.example.meals.presentation.mealdetails

import com.example.meals.domain.models.MealDetails


data class PlayerDetailsState(
    val isLoading: Boolean = false,
    val data: MealDetails? = null,
    val error: String = ""
) {
}
