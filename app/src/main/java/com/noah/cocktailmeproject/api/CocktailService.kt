package com.noah.cocktailmeproject.api

import com.noah.cocktailmeproject.api.model.CocktailData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailService {
    @GET("search.php?s=")
    fun searchCocktail(@Query("query") query: String): Call<CocktailData>

    @GET("filter.php?i=Gin")
    fun searchByIngredient(@Query("query") query: String): Call<CocktailData>

    @GET("lookup.php?i=")
    fun getCocktailById(cocktailId: Int): Call<CocktailData>

    @GET("random.php")
    fun getRandomCocktail(): Call<CocktailData>
}