package ua.example.mealdesc

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import ua.example.mealdesc.ViewModel.MealViewModel
import ua.example.mealdesc.models.Meal
import ua.example.mealdesc.ui.theme.MealDescTheme

@Composable
fun mainScreen(
    mealState: MealViewModel.MealState,
    onClick: (Meal)->Unit
){
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            mealState.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            mealState.error != null ->{
                Text(
                    mealState.error.toString(),
                    modifier = Modifier.align(Alignment.Center), 
                    style = MaterialTheme.typography.caption
                )
            }
            else-> mealsView(mealsList = mealState.list, onClick)
        }
    }
}

@Composable
fun mealsView(mealsList: List<Meal>, onClick: (Meal)->Unit){
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ){
        items(mealsList){
                item ->
            itemView(item = item, onClick)
        }
    }
}

@Composable
fun itemView(item:Meal, onClick: (Meal)->Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable{ onClick(item) }
    ) {
        Image(
            painter = rememberAsyncImagePainter(item.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )
        Text(text = item.name, style = MaterialTheme.typography.h5)
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    MealDescTheme {
        //mealsView(mealsList = emptyList())
    }
}