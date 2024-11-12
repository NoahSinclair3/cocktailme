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

class CocktailsManager(database: AppDatabase) {
    private var _cocktailsResponse = mutableStateOf<List<Cocktail>>(emptyList())

    val cocktailResponse: MutableState<List<Cocktail>>
        @Composable get() = remember{
            _cocktailsResponse
        }

    init {
        getCocktails(database)
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getCocktails(database: AppDatabase){
        val service = Api.retrofitService.getRandomCocktail()

        service.enqueue(object : Callback<CocktailData> {
            override fun onResponse(
                call: Call<CocktailData>,
                response: Response<CocktailData>
            ) {
                if (response.isSuccessful) {
                    Log.i("Data", "Data Loaded")
                    _cocktailsResponse.value = response.body()?.drinks ?: emptyList()
                    Log.i("DataStream", _cocktailsResponse.toString())

                    GlobalScope.launch {
                        saveDataToDatabase(database, _cocktailsResponse.value)
                    }
                }
            }

            override fun onFailure(call: Call<CocktailData>, t: Throwable) {
                Log.d("error", { t.message }.toString())
            }

        })
    }

    private suspend fun saveDataToDatabase(database: AppDatabase, movies: List<Cocktail>) {
        Log.i("RDB", "Save Data function called")
        database.cocktailOperations().insertAllCocktails(movies)
    }
}