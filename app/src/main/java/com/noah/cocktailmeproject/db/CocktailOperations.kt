package com.noah.cocktailmeproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.noah.cocktailmeproject.api.model.Cocktail

@Dao
interface CocktailOperations {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCocktails(cocktails: List<Cocktail>)

    @Query("SELECT * FROM cocktails WHERE idDrink = :id")
    fun getCocktailById(id: String): Cocktail?

    @Update
    fun updateCocktail(cocktail: Cocktail)
}