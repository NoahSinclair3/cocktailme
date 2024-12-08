package com.noah.cocktailmeproject.viewmodels

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.noah.cocktailmeproject.api.Api
import com.noah.cocktailmeproject.api.model.Cocktail
import com.noah.cocktailmeproject.api.model.CocktailData
import com.noah.cocktailmeproject.db.AppDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A viewmodel for the different screens in the app.
 *
 * Inherits from the ViewModel class
 */
class CocktailViewModel : ViewModel() {
    var cocktails = mutableStateOf<List<Cocktail>>(emptyList())
    var cocktail: Cocktail? = null
    var randomCocktail = mutableStateOf<List<Cocktail>>(emptyList())
    var query = mutableStateOf("")

    /**
     * A function for searching a cocktail.
     *
     * @param cocktail the name of the cocktail to be searched.
     * @param database the database of the app.
     */
    @OptIn(DelicateCoroutinesApi::class)
    fun searchCocktail(cocktail:String, database: AppDatabase){
        val service = Api.retrofitService.searchCocktail(cocktail)
        service.enqueue(object : Callback<CocktailData> {
            /**
             * A function for overriding the onResponse action.
             *
             * @param call the cocktail data call.
             * @param response the response to the api for cocktail data..
             */
            override fun onResponse(call: Call<CocktailData>, response: Response<CocktailData>) {
                if (response.isSuccessful){
                    Log.i("SearchData", "testing testing")
                    cocktails.value = response.body()?.drinks ?: emptyList()
                    Log.i("Value Found", cocktails.toString())
                    GlobalScope.launch {
                        database.cocktailOperations().insertAllCocktails(cocktails=cocktails.value)
                    }
                }
            }

            /**
             * A function for overriding the onFailure of a response.
             *
             * @param call the cocktail data call.
             * @param t the throwable message.
             */
            override fun onFailure(call: Call<CocktailData>, t: Throwable) {
                Log.d("search error", "${t.message}")
            }

        })

    }

    /**
     * A function for getting a random cocktail from the api.
     *
     * @param database the database of the app.
     */
    @OptIn(DelicateCoroutinesApi::class)
    fun getRandomCocktail(database: AppDatabase){
        val service = Api.retrofitService.getRandomCocktail()
        service.enqueue(object : Callback<CocktailData> {
            /**
             * A function for overriding the onResponse action.
             *
             * @param call the cocktail data call.
             * @param response the response to the api for cocktail data..
             */
            override fun onResponse(call: Call<CocktailData>, response: Response<CocktailData>) {
                if (response.isSuccessful){
                    Log.i("Random cocktail", "testing testing")
                    //randomCocktail.value += response.body()?.drinks ?: emptyList()
                    cocktail = response.body()?.drinks?.get(0)
                    randomCocktail.value += cocktail!!
                    Log.i("Value Found", randomCocktail.toString())
                    GlobalScope.launch {
                        database.cocktailOperations().insertAllCocktails(cocktails=randomCocktail.value)
                    }
                }
            }

            /**
             * A function for overriding the onFailure of a response.
             *
             * @param call the cocktail data call.
             * @param t the throwable message.
             */
            override fun onFailure(call: Call<CocktailData>, t: Throwable) {
                Log.d("random cocktail error", "${t.message}")
            }

        })
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun updateCocktail(db: AppDatabase, cocktail: Cocktail){
        GlobalScope.launch {
            db.cocktailOperations().updateCocktail(cocktail)
        }
    }
}