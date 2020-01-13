// File MyDatabase.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.uldskull.roomwordsample.RelationExperiment.converter.Converter
import com.uldskull.roomwordsample.RelationExperiment.dao.MatchDao
import com.uldskull.roomwordsample.RelationExperiment.dao.UserDao
import com.uldskull.roomwordsample.RelationExperiment.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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
    abstract fun userDao(): UserDao?
    abstract fun matchDao(): MatchDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null


        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ) : MyDatabase?{

            if (INSTANCE != null) {
                return INSTANCE
            }

            synchronized(this){
                INSTANCE = Room.inMemoryDatabaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java
                )
                    .addCallback(
                        MyDatabaseCallback(
                            scope
                        )
                    )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }


        private class MyDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
              /*
                INSTANCE?.let { database ->

                    scope.launch {
                        populateDatabase(database.userDao())
                    }
                }
                */

            }


            suspend fun populateDatabase(userDao: UserDao?){
                userDao?.deleteAll()


                var player = Player("Pedrosa","second", null)

                userDao?.insertPlayer(player)

                Log.i("INFO",player.id.toString()+" " + player.name)
            }
        }
    }
}