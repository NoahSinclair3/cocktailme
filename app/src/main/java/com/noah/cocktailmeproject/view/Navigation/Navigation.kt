package com.noah.cocktailmeproject.view.Navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.noah.cocktailmeproject.R
import com.noah.cocktailmeproject.destinations.Destination

/**
 * A composable function for the bottom navigation bar.
 *
 * @param navController the nav controller for the app.
 */
@Composable
fun BottomNav(navController: NavHostController) {
    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination

        val ic_main = painterResource(id = R.drawable.ic_main)
        val ic_all = painterResource(id = R.drawable.ic_all)
        val ic_search = painterResource(id = R.drawable.ic_search)

        NavigationBarItem(
            selected = currentDestination?.route == Destination.Main.route,
            onClick = { navController.navigate(Destination.Main.route){
                popUpTo(Destination.Main.route)
                launchSingleTop = true
            } },
            icon = { Icon(painter = ic_main, contentDescription = "Main") },
            label = {Text(text=Destination.Main.route)

            }
        )
        NavigationBarItem(
            selected = currentDestination?.route == Destination.All.route,
            onClick = { navController.navigate(Destination.All.route){
                popUpTo(Destination.All.route)
                launchSingleTop = true
            } },
            icon = { Icon(painter = ic_all, contentDescription = "All") },
            label = {Text(text=Destination.All.route)

            }
        )
        NavigationBarItem(
            selected = currentDestination?.route == Destination.Search.route,
            onClick = { navController.navigate(Destination.Search.route){
                popUpTo(Destination.Search.route)
                launchSingleTop = true
            } },
            icon = { Icon(painter = ic_search, contentDescription = "Search") },
            label = {Text(text=Destination.Search.route)

            }
        )
    }
}