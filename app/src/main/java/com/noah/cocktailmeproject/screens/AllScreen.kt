package com.noah.cocktailmeproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.noah.cocktailmeproject.api.CocktailsManager
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.noah.cocktailmeproject.api.model.Cocktail

/**
 * A composable function for displaying all cocktails.
 *
 * @param modifier modifiers for the composable.
 * @param cocktailsManager the cocktail manager for the app.
 * @param navController the navcontroller for the app.
 */
@Composable
fun AllScreen(
    modifier: Modifier = Modifier,
    cocktailsManager: CocktailsManager,
    navController: NavController){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)

    ){
        var cocktails by remember { mutableStateOf<List<Cocktail>>(emptyList()) }
        cocktails = cocktailsManager.cocktailResponse.value.sortedBy { it.strDrink }
        LazyColumn{
            items(cocktails){ cocktail ->
                CocktailItem(cocktail = cocktail, navController = navController)
            }
        }
    }

}