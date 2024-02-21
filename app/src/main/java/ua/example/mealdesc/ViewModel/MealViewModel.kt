package ua.example.mealdesc.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ua.example.mealdesc.models.Meal

class MealViewModel() : ViewModel(){
    private val factory: MealViewModelFactory = MealViewModelFactory.getInstance()
    val _mealState = mutableStateOf(MealState())
        get() = field

    init {
        fetchMeals()
    }

    private fun fetchMeals(){
        viewModelScope.launch {
            try {
                val response = factory.getMeals()
                _mealState.value=_mealState.value.copy(
                    loading = false,
                    list = response.meals,
                    error = null
                )
            }
            catch (e:Exception){
                _mealState.value=_mealState.value.copy(
                    loading = false,
                    error = e.message
                )
            }
        }
    }

    data class MealState(
        val loading: Boolean = true,
        val list: List<Meal> = emptyList(),
        val error: String? = null
    )
}