package com.noah.cocktailmeproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.noah.cocktailmeproject.api.model.Cocktail

/**
 * An interface for performing operations on the database.
 */
@Dao
interface CocktailOperations {
    /**
     * A function for inserting a list of cocktails to the database.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCocktails(cocktails: List<Cocktail>)

    /**
     * A function for getting a cocktail by id form the database
     */
    @Query("SELECT * FROM cocktails WHERE idDrink = :id")
    fun getCocktailById(id: String): Cocktail?

    /**
     * A function for updating cocktail data in the database.
     */
    @Update
    fun updateCocktail(cocktail: Cocktail)

    /**
     * A function to get all cocktails in the database.
     */
    @Query("SELECT * FROM cocktails")
    fun getAllCocktails(): List<Cocktail>
}