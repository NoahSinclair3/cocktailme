package com.noah.cocktailmeproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.noah.cocktailmeproject.api.CocktailsManager
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.draw.clip
import com.noah.cocktailmeproject.api.model.Cocktail
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MainScreen(modifier: Modifier = Modifier, cocktailsManager: CocktailsManager, navController: NavController){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)

    ){
        Text(
            text = "Home",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
        val cocktails = cocktailsManager.cocktailResponse.value

        LazyColumn{
            items(cocktails){ cocktail ->
                CocktailItem(cocktail = cocktail, navController = navController)
            }
        }
    }

}

@Composable
fun CocktailItem(
    cocktail: Cocktail,
    navController: NavController
){
    Row(
        modifier = Modifier
            .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))
            .padding(5.dp)
            .fillMaxWidth()
            .background(Color.White)
            .clickable {
                navController.navigate("cocktail/${cocktail.idDrink}")
            }
    ){
        AsyncImage(
            modifier = Modifier
                .padding(5.dp)
                .size(64.dp)
                .clip(CircleShape),
            model = ImageRequest.Builder(
                LocalContext.current
            ).data(cocktail.strDrinkThumb)
                .build(),
            contentDescription = cocktail.strInstructions,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ){
            cocktail.strDrink?.let {
                Text(
                    text = it,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
            cocktail.strCategory?.let {
                Text(
                    text = it,
                    color = Color.Gray
                )
            }
        }
    }
}