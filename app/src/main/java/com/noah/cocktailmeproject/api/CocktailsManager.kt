package com.noah.cocktailmeproject.api

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
 * A class for managing cocktail data.
 *
 * @param database the database for cocktail data.
 */
class CocktailsManager(database: AppDatabase) {
    private var _cocktailsResponse = mutableStateOf<List<Cocktail>>(emptyList())

    val cocktailResponse: MutableState<List<Cocktail>>
        @Composable get() = remember{
            _cocktailsResponse
        }
    // Block to initialize when the app starts
    init {
        val allChar = "abcdefghijklmnopqrstuvwxyz0123456789"
        for (char in allChar) {
            getCocktails(char,database)
        }
        GlobalScope.launch {
            saveDataToDatabase(database, _cocktailsResponse.value)
        }
    }

    /**
     * A function for getting a list of cocktails by first letter.
     *
     * @param letter the letter to search by.
     * @param database the database used for cocktail data.
     */
    @OptIn(DelicateCoroutinesApi::class)
    private fun getCocktails(letter: Char,database: AppDatabase){
        val service = Api.retrofitService.searchCocktailByFirstLetter(letter.toString())

        service.enqueue(object : Callback<CocktailData> {
            /**
             * A function for overriding the onResponse action.
             *
             * @param call the cocktail data call.
             * @param response the response to the api for cocktail data..
             */
            override fun onResponse(
                call: Call<CocktailData>,
                response: Response<CocktailData>
            ) {
                if (response.isSuccessful) {
                    Log.i("Data", "Data Loaded")
                    _cocktailsResponse.value += response.body()?.drinks ?: emptyList()
                    Log.i("DataStream", _cocktailsResponse.toString())
                }
            }

            /**
             * A function for overriding the onFailure of a response.
             *
             * @param call the cocktail data call.
             * @param t the throwable message.
             */
            override fun onFailure(call: Call<CocktailData>, t: Throwable) {
                Log.d("error", { t.message }.toString())
            }

        })
    }

    /**
     *  A function that saves the data to the database.
     *
     *  @param database the database used for cocktail data.
     *  @param cocktails the list of cocktails to be inserted to the database.
     */
    private suspend fun saveDataToDatabase(database: AppDatabase, cocktails: List<Cocktail>) {
        Log.i("RDB", "Save Data function called")
        database.cocktailOperations().insertAllCocktails(cocktails)
    }
}