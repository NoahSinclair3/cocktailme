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
    var dateModified: String? = null,
    @Json(name = "idDrink")
    @PrimaryKey(autoGenerate = false)
    var idDrink: String,
    @Json(name = "strAlcoholic")
    var strAlcoholic: String? = null,
    @Json(name = "strCategory")
    var strCategory: String? = null,
    @Json(name = "strCreativeCommonsConfirmed")
    var strCreativeCommonsConfirmed: String? = null,
    @Json(name = "strDrink")
    var strDrink: String? = null,
    @Json(name = "strDrinkAlternate")
    var strDrinkAlternate: String? = null,
    @Json(name = "strDrinkThumb")
    var strDrinkThumb: String? = null,
    @Json(name = "strGlass")
    var strGlass: String? = null,
    @Json(name = "strIBA")
    var strIBA: String? = null,
    @Json(name = "strImageAttribution")
    var strImageAttribution: String? = null,
    @Json(name = "strImageSource")
    var strImageSource: String? = null,
    @Json(name = "strIngredient1")
    var strIngredient1: String? = null,
    @Json(name = "strIngredient10")
    var strIngredient10: String? = null,
    @Json(name = "strIngredient11")
    var strIngredient11: String? = null,
    @Json(name = "strIngredient12")
    var strIngredient12: String? = null,
    @Json(name = "strIngredient13")
    var strIngredient13: String? = null,
    @Json(name = "strIngredient14")
    var strIngredient14: String? = null,
    @Json(name = "strIngredient15")
    var strIngredient15: String? = null,
    @Json(name = "strIngredient2")
    var strIngredient2: String? = null,
    @Json(name = "strIngredient3")
    var strIngredient3: String? = null,
    @Json(name = "strIngredient4")
    var strIngredient4: String? = null,
    @Json(name = "strIngredient5")
    var strIngredient5: String? = null,
    @Json(name = "strIngredient6")
    var strIngredient6: String? = null,
    @Json(name = "strIngredient7")
    var strIngredient7: String? = null,
    @Json(name = "strIngredient8")
    var strIngredient8: String? = null,
    @Json(name = "strIngredient9")
    var strIngredient9: String? = null,
    @Json(name = "strInstructions")
    var strInstructions: String? = null,
    @Json(name = "strInstructionsDE")
    var strInstructionsDE: String? = null,
    @Json(name = "strInstructionsES")
    var strInstructionsES: String? = null,
    @Json(name = "strInstructionsFR")
    var strInstructionsFR: String? = null,
    @Json(name = "strInstructionsIT")
    var strInstructionsIT: String? = null,
    @Json(name = "strInstructionsZH-HANS")
    var strInstructionsZHHANS: String? = null,
    @Json(name = "strInstructionsZH-HANT")
    var strInstructionsZHHANT: String? = null,
    @Json(name = "strMeasure1")
    var strMeasure1: String? = null,
    @Json(name = "strMeasure10")
    var strMeasure10: String? = null,
    @Json(name = "strMeasure11")
    var strMeasure11: String? = null,
    @Json(name = "strMeasure12")
    var strMeasure12: String? = null,
    @Json(name = "strMeasure13")
    var strMeasure13: String? = null,
    @Json(name = "strMeasure14")
    var strMeasure14: String? = null,
    @Json(name = "strMeasure15")
    var strMeasure15: String? = null,
    @Json(name = "strMeasure2")
    var strMeasure2: String? = null,
    @Json(name = "strMeasure3")
    var strMeasure3: String? = null,
    @Json(name = "strMeasure4")
    var strMeasure4: String? = null,
    @Json(name = "strMeasure5")
    var strMeasure5: String? = null,
    @Json(name = "strMeasure6")
    var strMeasure6: String? = null,
    @Json(name = "strMeasure7")
    var strMeasure7: String? = null,
    @Json(name = "strMeasure8")
    var strMeasure8: String? = null,
    @Json(name = "strMeasure9")
    var strMeasure9: String? = null,
    @Json(name = "strTags")
    var strTags: String? = null,
    @Json(name = "strVideo")
    var strVideo: String? = null
)