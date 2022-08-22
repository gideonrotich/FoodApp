package com.example.meals.data.mapper

import com.example.meals.data.dto.MealDetailsDto
import com.example.meals.domain.models.MealDetails
import com.example.meals.domain.models.Meals

fun MealDetailsDto.toMeal() : MealDetails{
    return MealDetails(
        strArea = strArea,
        strCategory = strCategory,
        strMeal = strMeal,
        strMealThumb = strMealThumb,
        strTags = strTags,
        strIngredient1 = strIngredient1,
        strIngredient10 = strIngredient10,
        strIngredient11 = strIngredient11,
        strIngredient12 = strIngredient12,
        strIngredient13 = strIngredient13,
        strIngredient14 = strIngredient14,
        strIngredient15 = strIngredient15
    )
}

fun MealDetailsDto.toMeals() : Meals{
    return Meals(
        strMealThumb = strMealThumb,
        idMeal = idMeal,
        strMeal = strMeal,
        strCategory = strCategory
    )
}