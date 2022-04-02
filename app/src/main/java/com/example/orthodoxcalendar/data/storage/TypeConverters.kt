package com.example.orthodoxcalendar.data.storage

import androidx.room.TypeConverter

class StringListConverter {
    @TypeConverter
    fun fromListOfStrings(list: List<String>): String = list.joinToString(separator = ",")

    @TypeConverter
    fun toListOfStrings(string: String): List<String> = string.split(",")
}