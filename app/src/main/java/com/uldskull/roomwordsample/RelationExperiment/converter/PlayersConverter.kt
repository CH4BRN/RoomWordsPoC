// File PlayersConverter.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 *   Class "PlayersConverter" :
 *   TODO: Fill class use.
 **/
class PlayersConverter {

    /**
     * convertira une une chaine de caractères (au format Json) en liste d’identifiant Player
     */
    @TypeConverter
    fun stringToPlayers(value: String): List<Long> {
        val listPlayers = object : TypeToken<Long>() {}.type
        return Gson().fromJson(value, listPlayers)
    }

    /**
     * convertira une liste d’identifiant Player en une chaine de caractères (au format Json)
     */
    @TypeConverter
    fun playersToString(list: List<Long>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}