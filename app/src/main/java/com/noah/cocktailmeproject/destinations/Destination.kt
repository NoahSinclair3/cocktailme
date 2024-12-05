package com.noah.cocktailmeproject.destinations

sealed class Destination(val route: String) {
    object Main: Destination("main")
    object All: Destination("all")
    object Search: Destination("search")
    object Cocktail: Destination("cocktail/{idDrink}")
}