package ua.example.mealdesc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ua.example.mealdesc.models.Meal

@Composable
fun detailListScreen(meal: Meal, onClick: ()->Unit){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Spacer(modifier = Modifier.width(80.dp))
                    Text(text = meal.name,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h4
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onClick() }) {
                        Icon(Icons.Default.ArrowBack,"")
                    }
                },
                elevation = 12.dp,
                backgroundColor = Color.LightGray,
                contentColor = Color.Black
            )
        }, content = {
        })
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(meal.image),
            contentDescription = null,
            Modifier
                .wrapContentSize()
                .aspectRatio(1f)
        )
        Text(
            text = meal.description,
            Modifier.verticalScroll(rememberScrollState()),
            textAlign = TextAlign.Justify
        )
    }
}