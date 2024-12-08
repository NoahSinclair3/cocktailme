package com.noah.cocktailmeproject.destinations

/**
 * A class for routing destinations when switching screens.
 */
sealed class Destination(val route: String) {
    object Main: Destination("main") //Routes to the main screen
    object All: Destination("all") //Routes to the all screen
    object Search: Destination("search") //Routes to the search screen
    object SignIn: Destination("signIn") //Routes to the sign in screen
    object SignUp: Destination("signUp") //Routes to the sign up screen
    object ResetPassword: Destination("resetPassword") //Routes to the sign up screen
    object Cocktail: Destination("cocktail/{idDrink}") //Routes to the cocktail screen
    object Edit: Destination("edit") //Routes to the all screen
}