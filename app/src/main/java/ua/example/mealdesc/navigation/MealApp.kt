package ua.example.mealdesc.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ua.example.mealdesc.ViewModel.MealViewModel
import ua.example.mealdesc.mainScreen
import ua.example.mealdesc.models.Meal
import ua.example.mealdesc.screens.detailListScreen

@Composable
fun MealApp(
    navHostController:NavHostController
) {
    val mealViewModel: MealViewModel = viewModel()
    val mealState by mealViewModel._mealState
    NavHost(navController = navHostController, startDestination = NavigationRoute.ListScreen.route ){
        composable(NavigationRoute.ListScreen.route){
            mainScreen(mealState = mealState){
                navHostController.currentBackStackEntry?.savedStateHandle?.set("meal", it)
                navHostController.navigate(NavigationRoute.DetailListScreen.route)
            }
        }
        composable(NavigationRoute.DetailListScreen.route){
            val meal = navHostController.previousBackStackEntry?.savedStateHandle?.
            get<Meal>("meal")?:Meal("","","", "")
            detailListScreen(meal = meal){
                navHostController.navigate(NavigationRoute.ListScreen.route)
            }
        }
    }
}