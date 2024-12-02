package com.noah.cocktailmeproject.screens

import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.noah.cocktailmeproject.db.AppDatabase
import com.noah.cocktailmeproject.viewmodels.CocktailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(modifier: Modifier, database: AppDatabase, navController: NavController, viewModel: CocktailViewModel){
    var active by remember { mutableStateOf(false) }
    var query by rememberSaveable { viewModel.searchTerm }

    Box(
        modifier = Modifier
            .background(Color.White)
    ){
        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
        ) {
            SearchBar(modifier = Modifier.fillMaxWidth(),
                query = viewModel.searchTerm.value,
                onQueryChange = { viewModel.searchTerm.value = it },
                onSearch = {
                    active = false
                    viewModel.searchCocktail(query,database)
                    query = ""
                           },
                active = active,
                onActiveChange = { active = it },
                placeholder = { Text(text = "Search Cocktail Name")},
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")},
                trailingIcon = {
                    if (active) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close Icon",
                            modifier = Modifier.clickable {
                                if (query.isNotEmpty()) {
                                    query = ""
                                }else{
                                    active = false
                                }})
                    }
                               },
                   ) {
                
            }

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )

            for (cocktail in viewModel.cocktails.value) {
                LazyColumn{
                    items(viewModel.cocktails.value){ cocktail ->
                        CocktailItem(cocktail, navController = navController)
                    }
                }
            }

        }

    }

}