package com.example.meals.domain.usecases

import com.bumptech.glide.load.HttpException
import com.example.meals.core.Resource
import com.example.meals.data.mapper.toMeals
import com.example.meals.domain.models.Meals
import com.example.meals.domain.repository.MealsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception

import javax.inject.Inject

class MealSearchUseCase @Inject constructor(private val repository: MealsRepository) {

    operator fun invoke(s: String): Flow<Resource<List<Meals>>> = flow{
        try {
            emit(Resource.Loading())
            val data = repository.getMeals(s)
            val domainData =
                if (data.meal != null) data.meal.map { it -> it.toMeals() } else emptyList()
            emit(Resource.Success(data = domainData))
        }catch (e: HttpException){
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown Error Occurred"))
        }catch (e: IOException){
            emit(Resource.Error(message = e.localizedMessage ?: "Check connectivity"))
        }catch (e: Exception){

        }

    }


}