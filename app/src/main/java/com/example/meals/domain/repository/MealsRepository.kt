package com.example.meals.domain.repository

import com.example.meals.data.dto.MealsDto

interface MealsRepository {
    suspend fun getMeals(s: String): MealsDto
    suspend fun getMealsDetails(i: String): MealsDto
}
