package com.noah.cocktailmeproject.utilities

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Converters {
    private val moshi = Moshi.Builder().build()

    /**
     * Converts a type from string in to an int.
     *
     * @param value the string of values.
     */
    @TypeConverter
    fun fromString(value: String?): List<Int>?{
        if (value == null) return null

        val listType = Types.newParameterizedType(List::class.java, Integer::class.java)
        val adapter: JsonAdapter<List<Int>> = moshi.adapter(listType)

        return adapter.fromJson(value)
    }

    /**
     * Converts a list of integers to a string.
     *
     * @param list the list of integers.
     */
    @TypeConverter
    fun ListToString(list: List<Int>?): String?{
        if (list == null) return null

        val listType = Types.newParameterizedType(List::class.java, Integer::class.java)
        val adapter: JsonAdapter<List<Int>> = moshi.adapter(listType)

        return adapter.toJson(list)
    }
}