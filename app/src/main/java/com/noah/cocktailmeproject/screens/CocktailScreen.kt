package com.noah.cocktailmeproject.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.noah.cocktailmeproject.R
import com.noah.cocktailmeproject.api.model.Cocktail
import com.noah.cocktailmeproject.db.AppDatabase
import com.noah.cocktailmeproject.destinations.Destination
import com.noah.cocktailmeproject.viewmodels.CocktailViewModel

/**
 * A composable function to display a cocktail.
 *
 * @param cocktail the cocktail to display.
 * @param modifier modifier for the composable.
 * @param navController the nav controller of the app
 */
@Composable
fun CocktailScreen(
    cocktail: Cocktail,
    modifier: Modifier = Modifier,
    navController: NavController
){
    val alcoholic = painterResource(id = R.drawable.alcoholic) //Alcoholic symbol
    val nonAlcoholic = painterResource(id = R.drawable.no_alcohol) //Non-Alcoholic symbol
    Box(
        modifier = modifier
            .padding(start = 5.dp, top = 75.dp, end = 5.dp, bottom = 95.dp)
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .clickable { navController.popBackStack() }
                    )
                    Row(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(end = 16.dp)
                    ) {
                        cocktail.strAlcoholic?.let {
                            if (cocktail.strAlcoholic == "Alcoholic") {
                                Image(
                                    painter = alcoholic,
                                    contentDescription = "Alcoholic",
                                    modifier = Modifier
                                        .size(80.dp)
                                )
                            } else {
                                Image(
                                    painter = nonAlcoholic,
                                    contentDescription = "Non-Alcoholic",
                                    modifier = Modifier
                                        .size(80.dp)
                                )
                            }
                        }
                    }
                }
        AsyncImage(
                    alignment = Alignment.Center,
                    modifier = modifier
                        .size(350.dp)
                        .clip(CircleShape),
                    model = ImageRequest.Builder(
                        LocalContext.current
                    ).data(cocktail.strDrinkThumb).build(),
                    contentDescription = cocktail.strInstructions,
                    contentScale = ContentScale.Crop
                )
                cocktail.strDrink?.let {
                    Text(
                        textAlign = TextAlign.Center,
                        text = it,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 50.sp),
                        modifier = modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                    )
                }
                Text(
                    text = "Ingredients",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 45.sp,
                    modifier = modifier
                        .padding(top = 16.dp)
                        .align(Alignment.Center)
                        .fillMaxWidth()
                )
                Column(
                    modifier = modifier.padding(start = 16.dp)
                ) {
                    cocktail.strIngredient1?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure1 != null) {
                            ingredients = "• $it (${cocktail.strMeasure1})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient2?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure2 != null) {
                            ingredients = "• $it (${cocktail.strMeasure2})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient3?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure3 != null) {
                            ingredients = "• $it (${cocktail.strMeasure3})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient4?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure4 != null) {
                            ingredients = "• $it (${cocktail.strMeasure4})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient5?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure5 != null) {
                            ingredients = "• $it (${cocktail.strMeasure5})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient6?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure6 != null) {
                            ingredients = "• $it (${cocktail.strMeasure6})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient7?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure7 != null) {
                            ingredients = "• $it (${cocktail.strMeasure7})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient8?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure8 != null) {
                            ingredients = "• $it (${cocktail.strMeasure8})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient9?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure9 != null) {
                            ingredients = "• $it (${cocktail.strMeasure9})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient10?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure10 != null) {
                            ingredients = "• $it (${cocktail.strMeasure10})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient11?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure11 != null) {
                            ingredients = "• $it (${cocktail.strMeasure11})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient12?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure12 != null) {
                            ingredients = "• $it (${cocktail.strMeasure12})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient13?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure13 != null) {
                            ingredients = "• $it (${cocktail.strMeasure13})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient14?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure14 != null) {
                            ingredients = "• $it (${cocktail.strMeasure14})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient15?.let {
                        var ingredients = ""
                        if (cocktail.strMeasure15 != null) {
                            ingredients = "• $it (${cocktail.strMeasure15})"}
                        else{
                            ingredients = "• $it"
                        }
                        Text(
                            text = ingredients,
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                }
                Text(
                    text = "Instructions",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 45.sp,
                    modifier = modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                )
                cocktail.strInstructions?.let {
                    Text(
                        text = it,
                        color = Color.Black,
                        fontSize = 24.sp,
                        modifier = modifier
                            .padding(start = 16.dp, top = 4.dp)
                            .fillMaxWidth()
                    )
                }
                Button(
                    onClick = { navController.navigate(Destination.Edit.route){
                        popUpTo(Destination.Edit.route)
                        launchSingleTop = true
                    }},
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text("Edit")
                }
            }
        }
    }
}


