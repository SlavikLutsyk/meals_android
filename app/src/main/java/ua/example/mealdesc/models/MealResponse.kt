package ua.example.mealdesc.models

import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("categories") var meals:List<Meal>
)
