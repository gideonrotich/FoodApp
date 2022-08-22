package com.example.meals.di

import com.example.meals.core.Constants
import com.example.meals.data.api.MealsApi
import com.example.meals.data.repository.MealsRepositoryImpl
import com.example.meals.domain.repository.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideMealAPI(): MealsApi{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MealsApi::class.java)
    }

    @Provides
    fun provideMealsRepository(mealsApi: MealsApi): MealsRepository{
        return MealsRepositoryImpl(mealsApi)
    }
}