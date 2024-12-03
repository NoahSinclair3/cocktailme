package com.noah.cocktailmeproject

import android.annotation.SuppressLint
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.noah.cocktailmeproject.api.CocktailsManager
import com.noah.cocktailmeproject.api.model.Cocktail
import com.noah.cocktailmeproject.db.AppDatabase
import com.noah.cocktailmeproject.destinations.Destination
import com.noah.cocktailmeproject.screens.CocktailScreen
import com.noah.cocktailmeproject.screens.MainScreen
import com.noah.cocktailmeproject.screens.SearchScreen
import com.noah.cocktailmeproject.ui.theme.CocktailMeProjectTheme
import com.noah.cocktailmeproject.view.Navigation.BottomNav
import com.noah.cocktailmeproject.viewmodels.CocktailViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun App(navController: NavHostController, modifier: Modifier, cocktailsManager: CocktailsManager, db: AppDatabase, viewModel: CocktailViewModel){
    var cocktail by remember {
        mutableStateOf<Cocktail?>(null)
    }

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
            composable(Destination.Cocktail.route) { navBackStackEntry ->
                val idDrink:String? = navBackStackEntry.arguments?.getString("idDrink")
                GlobalScope.launch{
                    if (idDrink != null){
                        cocktail = db.cocktailOperations().getCocktailById(idDrink)
                    }
                }
                cocktail?.let { CocktailScreen(it, modifier = Modifier.padding(), viewModel, db, navController)}
            }
        }
    }
}