package com.noah.cocktailmeproject.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CocktailData(
    @Json(name = "drinks")
    val drinks: List<Cocktail>
)