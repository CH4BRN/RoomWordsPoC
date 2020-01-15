// File KoinWordDatabase.kt
// @Author pierre.antoine - 15/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.koinRoom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uldskull.roomwordsample.domain.aggregates.Word
import com.uldskull.roomwordsample.infrastructure.data.word.WordDao

/**
 *   Class "KoinWordDatabase" :
 *   TODO: Fill class use.
 **/
@Database(entities = [Word::class], version = 1)
abstract class KoinWordDatabase : RoomDatabase() {

    abstract fun wordDao() : WordDao
// TODO : Fill class.
}