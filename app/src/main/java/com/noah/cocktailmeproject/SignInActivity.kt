package com.noah.cocktailmeproject

import android.annotation.SuppressLint
import android.content.Context
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.noah.cocktailmeproject.api.CocktailsManager
import com.noah.cocktailmeproject.api.model.Cocktail
import com.noah.cocktailmeproject.db.AppDatabase
import com.noah.cocktailmeproject.destinations.Destination
import com.noah.cocktailmeproject.screens.AllScreen
import com.noah.cocktailmeproject.screens.CocktailScreen
import com.noah.cocktailmeproject.screens.MainScreen
import com.noah.cocktailmeproject.screens.ResetPasswordScreen
import com.noah.cocktailmeproject.screens.SearchScreen
import com.noah.cocktailmeproject.screens.SignInScreen
import com.noah.cocktailmeproject.screens.SignUpScreen
import com.noah.cocktailmeproject.ui.theme.CocktailMeProjectTheme
import com.noah.cocktailmeproject.view.Navigation.BottomNav
import com.noah.cocktailmeproject.viewmodels.CocktailViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A class for the sign in screen activity.
 *
 * Inherits from Component Activity.
 */
class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CocktailMeProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val context: Context = applicationContext
                    val navController = rememberNavController()
                    SignInApp(modifier = Modifier.padding(innerPadding), context = context, navController = navController)
                }
            }

        }
    }
}

/**
 * A composable function for calling the sign in/up process to start.
 *
 * @param navController the nav controller of the app.
 * @param modifier modifiers for the composables.
 * @param context the context of the app
 */
@Composable
fun SignInApp(modifier: Modifier, context: Context, navController: NavHostController){
    NavHost(navController = navController, startDestination = Destination.SignIn.route){
        composable(Destination.SignIn.route){
            SignInScreen(modifier = modifier, context = context, navController = navController)
        }
        composable(Destination.SignUp.route){
            SignUpScreen(modifier = modifier, context = context, navController = navController)
        }
        composable(Destination.ResetPassword.route){
            ResetPasswordScreen(modifier = modifier, context = context, navController = navController)
        }
    }
}