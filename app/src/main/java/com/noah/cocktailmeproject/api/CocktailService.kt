package com.noah.cocktailmeproject.api

import com.noah.cocktailmeproject.api.model.CocktailData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CocktailService {
    @GET("search.php")
    fun searchCocktail(@Query("s") s: String): Call<CocktailData>

    @GET("search.php")
    fun searchCocktailByFirstLetter(@Query("f") f: String): Call<CocktailData>

    @GET("filter.php")
    fun searchByIngredient(@Query("i") i: String): Call<CocktailData>

    @GET("lookup.php")
    fun getCocktailById(@Query("i") i: Int): Call<CocktailData>

    @GET("random.php")
    fun getRandomCocktail(): Call<CocktailData>
}