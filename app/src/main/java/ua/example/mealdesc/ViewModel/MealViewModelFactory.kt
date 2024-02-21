package ua.example.mealdesc.ViewModel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ua.example.mealdesc.API.MealAPI
import ua.example.mealdesc.Constants

class MealViewModelFactory {
    private constructor()

    companion object{
        fun getInstance() = MealViewModelFactory()
    }
    private val retrofit = Retrofit.Builder().
    addConverterFactory(GsonConverterFactory.create()).
    baseUrl(Constants.base_url).build()

    private val mealService = retrofit.create(MealAPI::class.java)

    suspend fun getMeals() = mealService.getMeals()
}