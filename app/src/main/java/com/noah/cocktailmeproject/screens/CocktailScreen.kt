package com.noah.cocktailmeproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import com.noah.cocktailmeproject.viewmodels.CocktailViewModel

@Composable
fun CocktailScreen(
    cocktail: Cocktail,
    modifier: Modifier = Modifier,
    viewModel: CocktailViewModel,
    db: AppDatabase,
    navController: NavController
){
    val alcoholic = painterResource(id = R.drawable.alcoholic)
    val nonAlcoholic = painterResource(id = R.drawable.no_alcohol)
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
                Column(modifier = modifier.align(Alignment.TopStart)) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = modifier
                            .clickable { navController.popBackStack() }
                    )
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = modifier
                            .fillMaxWidth()
                    ) { }
                    cocktail.strAlcoholic?.let {
                        if(cocktail.strAlcoholic == "Alcoholic"){
                            Image(
                                painter = alcoholic,
                                contentDescription = "Alcoholic",
                                modifier = modifier
                                    .align(Alignment.End)
                                    .size(80.dp)
                                    .fillMaxWidth()
                            )
                        }else{
                            Image(
                                painter = nonAlcoholic,
                                contentDescription = "Non-Alcoholic",
                                modifier = modifier
                                    .align(Alignment.End)
                                    .size(80.dp)
                                    .fillMaxWidth()
                            )
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
                        Text(
                            text = "• $it (${cocktail.strMeasure1})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient2?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure2})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient3?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure3})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient4?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure4})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient5?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure5})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient6?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure6})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient7?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure7})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient8?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure8})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient9?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure9})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient10?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure10})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient11?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure11})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient12?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure12})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient13?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure13})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient14?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure14})",
                            color = Color.Black,
                            fontSize = 24.sp,
                            modifier = modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                    cocktail.strIngredient15?.let {
                        Text(
                            text = "• $it (${cocktail.strMeasure15})",
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
            }
        }
    }
}
