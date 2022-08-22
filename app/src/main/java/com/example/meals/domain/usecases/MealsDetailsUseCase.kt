package com.example.meals.domain.usecases

import com.example.meals.core.Resource
import com.example.meals.data.mapper.toMeal
import com.example.meals.domain.models.MealDetails
import com.example.meals.domain.repository.MealsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MealsDetailsUseCase @Inject constructor(private val repository: MealsRepository) {

    operator fun invoke(i: String): Flow<Resource<List<MealDetails>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getMealsDetails(i)
            val domainData =
                if (!data.meal.isNullOrEmpty()) data.meal.map { it -> it.toMeal() } else emptyList()
            emit(Resource.Success(data = domainData))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {

        }
    }

}