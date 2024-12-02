package com.noah.cocktailmeproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.noah.cocktailmeproject.api.model.Cocktail

@Composable
fun Cocktail(
    cocktail: Cocktail,
    navController: NavController
){
    Box(modifier = Modifier)
    {
        Row(
            modifier = Modifier
                .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp))
                .padding(5.dp)
                .fillMaxWidth()
                .background(Color.White)
                .clickable {
                    navController.navigate("cocktail/${cocktail.idDrink}")
                }
        ) {
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
            ) {
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
}