package com.example.meals.data.api

import com.example.meals.core.Constants.MEAL_DETAILS
import com.example.meals.core.Constants.SEARCH_MEAL
import com.example.meals.data.dto.MealsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MealsApi {
    @GET("json/v1/1/search.php?")
    suspend fun searchMeals(@Query("s")s:String): MealsDto

    @GET(MEAL_DETAILS)
    suspend fun getMealsDetails(@Path("i")i: String): MealsDto
}