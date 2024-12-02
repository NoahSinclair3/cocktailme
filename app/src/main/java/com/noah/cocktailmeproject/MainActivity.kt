package com.noah.cocktailmeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.noah.cocktailmeproject.api.CocktailsManager
import com.noah.cocktailmeproject.db.AppDatabase
import com.noah.cocktailmeproject.destinations.Destination
import com.noah.cocktailmeproject.screens.MainScreen
import com.noah.cocktailmeproject.screens.SearchScreen
import com.noah.cocktailmeproject.ui.theme.CocktailMeProjectTheme
import com.noah.cocktailmeproject.view.Navigation.BottomNav
import com.noah.cocktailmeproject.viewmodels.CocktailViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CocktailMeProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val db = AppDatabase.getInstance(applicationContext)
                    val viewModel = CocktailViewModel()
                    val cocktailsManager = CocktailsManager(db)
                    val navController = rememberNavController()
                    App(navController = navController, modifier = Modifier.padding(innerPadding), cocktailsManager = cocktailsManager, db = db, viewModel = viewModel)
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(navController: NavHostController, modifier: Modifier, cocktailsManager: CocktailsManager, db: AppDatabase, viewModel: CocktailViewModel){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Cocktail Me") }
            )
        },
        bottomBar = { BottomNav(navController = navController) }

    ){ paddingValues ->
        paddingValues.calculateBottomPadding()
        Spacer(modifier = Modifier.padding(10.dp))

        NavHost(navController = navController as NavHostController, startDestination = Destination.Main.route){
            composable(Destination.Main.route){
                MainScreen(modifier = Modifier.padding(paddingValues), cocktailsManager, navController )
            }
            composable(Destination.Search.route){
                SearchScreen(modifier = Modifier.padding(paddingValues), db, navController, viewModel)
            }
        }
    }
}