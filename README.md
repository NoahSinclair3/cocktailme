# COCKTAIL ME PROJECT

**Author: Noah Sinclair**

This project was to use an API to make an Android app for looking up different types of cocktails. While searching for different cocktails, you are able to look at their ingredients and instructions on how to make them.

## How it's made:
**Languages**: Kotlin

The app was built in Android Studio using Kotlin. It uses TheCocktailDb to fetch the API data and list of cocktails through the internet and is done in both the cocktails manager and the viewmodel. The screens are separated and use composables to build each screen. It has one viewmodel for all the screens to use, but the destinations for the screens are separated into the destination folder. The database used is RoomDB and should hold all the cocktail data. Firebase is used for the sign-in screen and an intent sends it to the main screen when signed in.

## Usage:
- Sign in to the main screen with username and password.
- Go to the main screen and if you feel like having fun, press the random cocktail generator.
- From the bottom navigation, you should be able to find all the cocktails in the menu.
- Also from the bottom navigation, you should be able to make your way to the search screen and search for any cocktails you want.
- From each of those screens, you can click on the cocktail of your choice and view a picture, ingredients, and instructions on how to make it.
