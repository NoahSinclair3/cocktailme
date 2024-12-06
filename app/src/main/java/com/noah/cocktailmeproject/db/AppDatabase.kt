package com.noah.cocktailmeproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.noah.cocktailmeproject.api.model.Cocktail
import com.noah.cocktailmeproject.utilities.Converters

/**
 * A class for the database of the app.
 *
 * Inherits for RoomDatabase
 */
@Database(entities = [Cocktail::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    /**
     * A function for performing operations on the database.
     */
    abstract fun cocktailOperations(): CocktailOperations

    // companion object implements Singleton Pattern
    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * Gets an instance if the database.
         *
         * @param context the application context.
         */
        fun getInstance(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Cocktail Me Project"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }

}