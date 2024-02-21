package ua.example.mealdesc.API

import retrofit2.http.GET
import ua.example.mealdesc.models.MealResponse

interface MealAPI {
    @GET("categories.php")
    suspend fun getMeals():MealResponse
}