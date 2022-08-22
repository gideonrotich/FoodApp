package com.example.meals.data.repository

import com.example.meals.data.api.MealsApi
import com.example.meals.data.dto.MealsDto
import com.example.meals.domain.repository.MealsRepository
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(private val mealsApi: MealsApi): MealsRepository {
    override suspend fun getMeals(s: String): MealsDto {
        return mealsApi.searchMeals(s)
    }

    override suspend fun getMealsDetails(i: String): MealsDto {
        return mealsApi.getMealsDetails(i)
    }
}