package com.noah.cocktailmeproject.api

import com.noah.cocktailmeproject.api.model.CocktailData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * An interface for the api endpoints.
 */
interface CocktailService {
    /**
     * Endpoint for searching a cocktail by name.
     *
     * @property s the string to be searched
     * @return a webserver request of cocktail data.
     */
    @GET("search.php")
    fun searchCocktail(@Query("s") s: String): Call<CocktailData>

    /**
     * Endpoint for searching a cocktail by first letter.
     *
     * @property f the string to be searched
     * @return a webserver request of cocktail data.
     */
    @GET("search.php")
    fun searchCocktailByFirstLetter(@Query("f") f: String): Call<CocktailData>

    /**
     * Endpoint for searching a cocktail by ingredient.
     *
     * @property i the string to be searched
     * @return a webserver request of cocktail data.
     */
    @GET("filter.php")
    fun searchByIngredient(@Query("i") i: String): Call<CocktailData>

    /**
     * Endpoint for searching a cocktail by id.
     *
     * @property i the string to be searched
     * @return a webserver request of cocktail data.
     */
    @GET("lookup.php")
    fun getCocktailById(@Query("i") i: Int): Call<CocktailData>

    /**
     * Endpoint for getting a random cocktail.
     *
     * @return a webserver request of cocktail data.
     */
    @GET("random.php")
    fun getRandomCocktail(): Call<CocktailData>
}