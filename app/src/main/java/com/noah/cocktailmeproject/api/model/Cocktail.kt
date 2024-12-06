package com.noah.cocktailmeproject.api.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * A class for a cocktail.
 *
 * @property dateModified date the cocktail was modified.
 * @property idDrink the id of the cocktail.
 * @property strAlcoholic tells if the drink is alcoholic or not.
 * @property strCategory the category of drink.
 * @property strCreativeCommonsConfirmed tells if the drink is creative commons.
 * @property strDrink the name if the drink.
 * @property strDrinkAlternate the alternate name of the drink.
 * @property strDrinkThumb the thumbnail of the drink.
 * @property strGlass type of glass the drink goes in.
 * @property strIBA international bartenders association classification.
 * @property strImageAttribution credit for the photo.
 * @property strImageSource source for the image.
 * @property strIngredient1 first ingredient.
 * @property strIngredient2 second ingredient.
 * @property strIngredient3 third ingredient.
 * @property strIngredient4 fourth ingredient.
 * @property strIngredient5 fifth ingredient.
 * @property strIngredient6 sixth ingredient.
 * @property strIngredient7 seventh ingredient.
 * @property strIngredient8 eighth ingredient.
 * @property strIngredient9 ninth ingredient.
 * @property strIngredient10 tenth ingredient.
 * @property strIngredient11 eleventh ingredient.
 * @property strIngredient12 twelfth ingredient.
 * @property strIngredient13 thirteenth ingredient.
 * @property strIngredient14 fourteenth ingredient.
 * @property strIngredient15 fifteenth ingredient.
 * @property strMeasure1 first ingredient measurement.
 * @property strMeasure2 second ingredient measurement.
 * @property strMeasure3 third ingredient measurement.
 * @property strMeasure4 fourth ingredient measurement.
 * @property strMeasure5 fifth ingredient measurement.
 * @property strMeasure6 sixth ingredient measurement.
 * @property strMeasure7 seventh ingredient measurement.
 * @property strMeasure8 eighth ingredient measurement.
 * @property strMeasure9 ninth ingredient measurement.
 * @property strMeasure10 tenth ingredient measurement.
 * @property strMeasure11 eleventh ingredient measurement.
 * @property strMeasure12 twelfth ingredient measurement.
 * @property strMeasure13 thirteenth ingredient measurement.
 * @property strMeasure14 fourteenth ingredient measurement.
 * @property strMeasure15 fifteenth ingredient measurement.
 * @property strInstructions instructions in english.
 * @property strInstructionsDE instructions in dutch.
 * @property strInstructionsES instructions in spanish.
 * @property strInstructionsFR instructions in french.
 * @property strInstructionsIT instructions in italian.
 * @property strInstructionsZHHANS miscellaneous instructions.
 * @property strInstructionsZHHANT miscellaneous instructions.
 * @property strTags tags for the drink.
 * @property strVideo video instructions for the drink.
 *
 */
@Entity(tableName = "cocktails")
@JsonClass(generateAdapter = true)
data class Cocktail(
    @Json(name = "dateModified")
    val dateModified: String? = null,
    @Json(name = "idDrink")
    @PrimaryKey(autoGenerate = false)
    val idDrink: String,
    @Json(name = "strAlcoholic")
    val strAlcoholic: String? = null,
    @Json(name = "strCategory")
    val strCategory: String? = null,
    @Json(name = "strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String? = null,
    @Json(name = "strDrink")
    val strDrink: String? = null,
    @Json(name = "strDrinkAlternate")
    val strDrinkAlternate: String? = null,
    @Json(name = "strDrinkThumb")
    val strDrinkThumb: String? = null,
    @Json(name = "strGlass")
    val strGlass: String? = null,
    @Json(name = "strIBA")
    val strIBA: String? = null,
    @Json(name = "strImageAttribution")
    val strImageAttribution: String? = null,
    @Json(name = "strImageSource")
    val strImageSource: String? = null,
    @Json(name = "strIngredient1")
    val strIngredient1: String? = null,
    @Json(name = "strIngredient10")
    val strIngredient10: String? = null,
    @Json(name = "strIngredient11")
    val strIngredient11: String? = null,
    @Json(name = "strIngredient12")
    val strIngredient12: String? = null,
    @Json(name = "strIngredient13")
    val strIngredient13: String? = null,
    @Json(name = "strIngredient14")
    val strIngredient14: String? = null,
    @Json(name = "strIngredient15")
    val strIngredient15: String? = null,
    @Json(name = "strIngredient2")
    val strIngredient2: String? = null,
    @Json(name = "strIngredient3")
    val strIngredient3: String? = null,
    @Json(name = "strIngredient4")
    val strIngredient4: String? = null,
    @Json(name = "strIngredient5")
    val strIngredient5: String? = null,
    @Json(name = "strIngredient6")
    val strIngredient6: String? = null,
    @Json(name = "strIngredient7")
    val strIngredient7: String? = null,
    @Json(name = "strIngredient8")
    val strIngredient8: String? = null,
    @Json(name = "strIngredient9")
    val strIngredient9: String? = null,
    @Json(name = "strInstructions")
    val strInstructions: String? = null,
    @Json(name = "strInstructionsDE")
    val strInstructionsDE: String? = null,
    @Json(name = "strInstructionsES")
    val strInstructionsES: String? = null,
    @Json(name = "strInstructionsFR")
    val strInstructionsFR: String? = null,
    @Json(name = "strInstructionsIT")
    val strInstructionsIT: String? = null,
    @Json(name = "strInstructionsZH-HANS")
    val strInstructionsZHHANS: String? = null,
    @Json(name = "strInstructionsZH-HANT")
    val strInstructionsZHHANT: String? = null,
    @Json(name = "strMeasure1")
    val strMeasure1: String? = null,
    @Json(name = "strMeasure10")
    val strMeasure10: String? = null,
    @Json(name = "strMeasure11")
    val strMeasure11: String? = null,
    @Json(name = "strMeasure12")
    val strMeasure12: String? = null,
    @Json(name = "strMeasure13")
    val strMeasure13: String? = null,
    @Json(name = "strMeasure14")
    val strMeasure14: String? = null,
    @Json(name = "strMeasure15")
    val strMeasure15: String? = null,
    @Json(name = "strMeasure2")
    val strMeasure2: String? = null,
    @Json(name = "strMeasure3")
    val strMeasure3: String? = null,
    @Json(name = "strMeasure4")
    val strMeasure4: String? = null,
    @Json(name = "strMeasure5")
    val strMeasure5: String? = null,
    @Json(name = "strMeasure6")
    val strMeasure6: String? = null,
    @Json(name = "strMeasure7")
    val strMeasure7: String? = null,
    @Json(name = "strMeasure8")
    val strMeasure8: String? = null,
    @Json(name = "strMeasure9")
    val strMeasure9: String? = null,
    @Json(name = "strTags")
    val strTags: String? = null,
    @Json(name = "strVideo")
    val strVideo: String? = null
)