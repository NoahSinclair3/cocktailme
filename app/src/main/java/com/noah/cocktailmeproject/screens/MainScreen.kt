package com.noah.cocktailmeproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.noah.cocktailmeproject.api.CocktailsManager
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import com.noah.cocktailmeproject.api.model.Cocktail
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.noah.cocktailmeproject.db.AppDatabase
import com.noah.cocktailmeproject.viewmodels.CocktailViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    cocktailsManager: CocktailsManager,
    viewModel: CocktailViewModel,
    db: AppDatabase,
    navController: NavController
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to Cocktail Me",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Look through our list of cocktails, or search for one with the tabs below! If you're feeling fun, hit the button below to bring up a random one and try to make it!",
                color = Color.Gray,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            var cocktail2 by remember { mutableStateOf<Cocktail?>(null) }

            Button(onClick = {
                viewModel.getRandomCocktail(db)
            }) {
                Text("Get Random Cocktail")
            }

            LazyColumn{
                items(viewModel.randomCocktail.value){ cocktail ->
                    cocktail2 = cocktail
                    CocktailItem(cocktail = cocktail, navController = navController)
                }
            }
            //cocktail2?.let { CocktailScreen(it, modifier = Modifier.padding(), navController)}
        }
    }
}

@Composable
fun CocktailItem(
    cocktail: Cocktail,
    navController: NavController
) {
    Row(
        modifier = Modifier
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
            model = ImageRequest.Builder(LocalContext.current)
                .data(cocktail.strDrinkThumb)
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
