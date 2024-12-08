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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.noah.cocktailmeproject.R
import com.noah.cocktailmeproject.api.model.Cocktail
import com.noah.cocktailmeproject.db.AppDatabase
import com.noah.cocktailmeproject.viewmodels.CocktailViewModel

/**
 * A composable screen to edit a cocktail.
 *
 * @param viewModel the viewmodel for the screens.
 * @param db the database for the app.
 * @param cocktail the cocktail to display.
 * @param modifier modifier for the composable.
 * @param navController the nav controller of the app.
 */
@Composable
fun EditScreen(
    db: AppDatabase,
    viewModel: CocktailViewModel,
    cocktail: Cocktail,
    modifier: Modifier = Modifier,
    navController: NavController
){
    var ingredient1 by remember { mutableStateOf(cocktail.strIngredient1) }
    var measurement1 by remember { mutableStateOf(cocktail.strMeasure1) }
    var ingredient2 by remember { mutableStateOf(cocktail.strIngredient2) }
    var measurement2 by remember { mutableStateOf(cocktail.strMeasure2) }
    var ingredient3 by remember { mutableStateOf(cocktail.strIngredient3) }
    var measurement3 by remember { mutableStateOf(cocktail.strMeasure3) }
    var ingredient4 by remember { mutableStateOf(cocktail.strIngredient4) }
    var measurement4 by remember { mutableStateOf(cocktail.strMeasure4) }
    var ingredient5 by remember { mutableStateOf(cocktail.strIngredient5) }
    var measurement5 by remember { mutableStateOf(cocktail.strMeasure5) }
    var ingredient6 by remember { mutableStateOf(cocktail.strIngredient6) }
    var measurement6 by remember { mutableStateOf(cocktail.strMeasure6) }
    var ingredient7 by remember { mutableStateOf(cocktail.strIngredient7) }
    var measurement7 by remember { mutableStateOf(cocktail.strMeasure7) }
    var ingredient8 by remember { mutableStateOf(cocktail.strIngredient8) }
    var measurement8 by remember { mutableStateOf(cocktail.strMeasure8) }
    var ingredient9 by remember { mutableStateOf(cocktail.strIngredient9) }
    var measurement9 by remember { mutableStateOf(cocktail.strMeasure9) }
    var ingredient10 by remember { mutableStateOf(cocktail.strIngredient10) }
    var measurement10 by remember { mutableStateOf(cocktail.strMeasure10) }
    var ingredient11 by remember { mutableStateOf(cocktail.strIngredient11) }
    var measurement11 by remember { mutableStateOf(cocktail.strMeasure11) }
    var ingredient12 by remember { mutableStateOf(cocktail.strIngredient12) }
    var measurement12 by remember { mutableStateOf(cocktail.strMeasure12) }
    var ingredient13 by remember { mutableStateOf(cocktail.strIngredient13) }
    var measurement13 by remember { mutableStateOf(cocktail.strMeasure13) }
    var ingredient14 by remember { mutableStateOf(cocktail.strIngredient14) }
    var measurement14 by remember { mutableStateOf(cocktail.strMeasure14) }
    var ingredient15 by remember { mutableStateOf(cocktail.strIngredient15) }
    var measurement15 by remember { mutableStateOf(cocktail.strMeasure15) }
    var instructions by remember { mutableStateOf(cocktail.strInstructions) }
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
                    Box{
                        Row{
                            ingredient1?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient1 = it
                                        cocktail.strIngredient1 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 1") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement1?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement1 = it
                                        cocktail.strMeasure1 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box{
                        Row{
                            ingredient2?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient2 = it
                                        cocktail.strIngredient2 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 2") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement2?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement2 = it
                                        cocktail.strMeasure2 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box{
                        Row{
                            ingredient3?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient3 = it
                                        cocktail.strIngredient3 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 3") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement3?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement3 = it
                                        cocktail.strMeasure3 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box {
                        Row {
                            ingredient4?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient4 = it
                                        cocktail.strIngredient4 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 4") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement4?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement4 = it
                                        cocktail.strMeasure4 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box {
                        Row {
                            ingredient5?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient5 = it
                                        cocktail.strIngredient5 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 5") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement5?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement5 = it
                                        cocktail.strMeasure5 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box {
                        Row {
                            ingredient6?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient6 = it
                                        cocktail.strIngredient6 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 6") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement6?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement6 = it
                                        cocktail.strMeasure6 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box {
                        Row {
                            ingredient7?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient7 = it
                                        cocktail.strIngredient7 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 7") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement7?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement7 = it
                                        cocktail.strMeasure7 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box {
                        Row {
                            ingredient8?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient8 = it
                                        cocktail.strIngredient8 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 8") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement8?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement8 = it
                                        cocktail.strMeasure8 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box {
                        Row {
                            ingredient9?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient9 = it
                                        cocktail.strIngredient9 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 9") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement9?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement9 = it
                                        cocktail.strMeasure9 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box {
                        Row {
                            ingredient10?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient10 = it
                                        cocktail.strIngredient10 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 10") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement10?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement10 = it
                                        cocktail.strMeasure10 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box {
                        Row {
                            ingredient11?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient11 = it
                                        cocktail.strIngredient11 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 11") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement11?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement11 = it
                                        cocktail.strMeasure11 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box {
                        Row {
                            ingredient12?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient12 = it
                                        cocktail.strIngredient12 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 12") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement12?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement12 = it
                                        cocktail.strMeasure12 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box {
                        Row {
                            ingredient13?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient13 = it
                                        cocktail.strIngredient13 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 13") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement13?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement13 = it
                                        cocktail.strMeasure13 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box {
                        Row {
                            ingredient14?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient14 = it
                                        cocktail.strIngredient14 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 14") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement14?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement14 = it
                                        cocktail.strMeasure14 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
                    }
                    Box {
                        Row {
                            ingredient15?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        ingredient15 = it
                                        cocktail.strIngredient15 = it},
                                    modifier = Modifier
                                        .padding(8.dp).width(150.dp),
                                    label = { Text("Ingredient 15") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                            measurement15?.let { it ->
                                TextField(
                                    value = it,
                                    onValueChange = {
                                        measurement15 = it
                                        cocktail.strMeasure15 = it},
                                    modifier = Modifier
                                        .padding(8.dp),
                                    label = { Text("Measurement") },
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                                )
                            }
                        }
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
                TextField(
                    value = instructions!!,
                    onValueChange = {
                        instructions = it
                        cocktail.strInstructions = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    label = { Text("Instructions") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
                )
                Button(
                    onClick = {
                        viewModel.updateCocktail(db,cocktail)
                        navController.popBackStack() },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text("Update")
                }
            }
        }
    }
}
