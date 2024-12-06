package com.noah.cocktailmeproject.destinations

/**
 * A class for routing destinations when switching screens.
 */
sealed class Destination(val route: String) {
    object Main: Destination("main") //Routes to the main screen
    object All: Destination("all") //Routes to the all screen
    object Search: Destination("search") //Routes to the search screen
    object Cocktail: Destination("cocktail/{idDrink}") //Routes to the cocktail screen
}