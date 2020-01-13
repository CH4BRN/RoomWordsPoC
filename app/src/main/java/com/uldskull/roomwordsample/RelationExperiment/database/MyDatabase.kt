// File MyDatabase.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.uldskull.roomwordsample.RelationExperiment.converter.Converter
import com.uldskull.roomwordsample.RelationExperiment.dao.MatchDao
import com.uldskull.roomwordsample.RelationExperiment.dao.UserDao
import com.uldskull.roomwordsample.RelationExperiment.model.*

/**
 * suivre -> http://tutos-android-france.com/room/
 *
 *   Class "MyDatabase" :
 *    nous implémentons autant de fonction que d’interface Dao et nous ajoutons les entités
 *    dans les paramètres de l’annotation @Database, ainsi que le numéro la version de notre
 *    base de donnée. Pour terminer, nous devons préciser les Converter qui doivent être
 *    utilisés pour les types personnalisés.
 **/
@Database(entities = arrayOf(
    Player::class, Coach::class, Team::class, Match::class, Score::class),
    version = 1)
@TypeConverters(Converter::class)
abstract class MyDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
    abstract fun matchDao(): MatchDao
// TODO : Fill class.
}