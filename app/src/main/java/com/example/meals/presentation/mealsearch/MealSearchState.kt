package com.example.meals.presentation.mealsearch

import com.example.meals.domain.models.Meals

data class MealSearchState(
    val isLoading: Boolean = false,
    val data: List<Meals>? = null,
    val error: String = ""
)
