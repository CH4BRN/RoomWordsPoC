// File MyDatabase.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.uldskull.roomwordsample.RelationExperiment.converter.Converter
import com.uldskull.roomwordsample.RelationExperiment.dao.UserDao
import com.uldskull.roomwordsample.RelationExperiment.model.*

/**
 *   Class "MyDatabase" :
 *   TODO: Fill class use.
 **/
@Database(entities = arrayOf(
    Player::class, Coach::class, Team::class, Match::class, Score::class),
    version = 1)
@TypeConverters(Converter::class)
abstract class MyDatabase : RoomDatabase(){
    abstract fun UserDao(): UserDao
// TODO : Fill class.
}