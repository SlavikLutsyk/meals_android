package ua.example.mealdesc.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    @SerializedName("idCategory") var id:String,
    @SerializedName("strCategory") var name:String,
    @SerializedName("strCategoryThumb") var image:String,
    @SerializedName("strCategoryDescription") var description:String
):Parcelable
