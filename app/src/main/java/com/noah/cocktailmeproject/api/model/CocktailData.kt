package com.noah.cocktailmeproject.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * A class for a list of cocktail drinks.
 *
 * @property drinks the list of cocktails.
 */
@JsonClass(generateAdapter = true)
data class CocktailData(
    @Json(name = "drinks")
    val drinks: List<Cocktail>
)