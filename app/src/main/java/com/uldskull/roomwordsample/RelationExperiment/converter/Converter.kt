// File Converter.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.converter

import androidx.room.TypeConverter
import java.util.*

/**
 *   Class "Converter" :
 *   TODO: Fill class use.
 **/
class Converter {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}