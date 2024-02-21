package ua.example.mealdesc.navigation

sealed class NavigationRoute(val route:String){
    object ListScreen : NavigationRoute("list_screen")
    object DetailListScreen : NavigationRoute("detail_list_screen")
}
