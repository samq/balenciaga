package com.balenciaga.utils

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {
    @TypeConverter
    fun stringListToString(list : List<String>) : String {
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun stringToStringList(string : String) : List<String> {
        return Json.decodeFromString(string)
    }
}