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

class CocktailViewModel : ViewModel() {

    val cocktails = mutableStateOf<List<Cocktail>>(emptyList())

    // search term
    val searchTerm = mutableStateOf("")

    // variable to keep track of Movie Icon state
    // movieIconState = mutableStateOf <Map<Int,Boolean>>(emptyMap())

    private var _cocktailsResponse = mutableStateOf<List<Cocktail>>(emptyList())

    val cocktailResponse: MutableState<List<Cocktail>>
        @Composable get() = remember{
            _cocktailsResponse
        }


    @OptIn(DelicateCoroutinesApi::class)
    fun searchCocktail(cocktail:String, database: AppDatabase){
        val service = Api.retrofitService.searchCocktail(cocktail)
        service.enqueue(object : Callback<CocktailData> {
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

            override fun onFailure(call: Call<CocktailData>, t: Throwable) {
                Log.d("search error", "${t.message}")
            }

        })

    }
}