// File WordRoomDatabase.kt
// @Author pierre.antoine - 06/01/2020 - No copyright.

package com.uldskull.roomwordsample.infrastructure.data.word

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.uldskull.roomwordsample.domain.aggregates.Synonym
import com.uldskull.roomwordsample.domain.aggregates.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 *   Class "WordRoomDatabase" :
 *   TODO: Fill class use.
 **/
//   we set exportSchema to false here to avoid a build warning.
//   In a real app, you should consider setting a directory for Room to
//   use to export the schema so you can check the current schema into your version control system.
@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {


    abstract fun wordDao(): WordDao

    companion object {
        //Singleton WordRoomDatabase, to prevent having multiple instances of the
        // database opened at the same time.
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        /**
         * getDatabase returns the singleton. It'll create the database the first time
         * it's accessed, using Room's database builder to create a RoomDatabase object
         * in the application context from the WordRoomDatabase class and names
         * it "word_database".
         * To launch a coroutine we need a CoroutineScope.
         */
        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): WordRoomDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    DatabaseContract.WordDatabaseEntries.DATABASE_NAME
                )
                    .addCallback(
                        WordDatabaseCallback(
                            scope
                        )
                    )
                    .addMigrations(MIGRATION_1_2)
                    .build()
                INSTANCE = instance
                return instance
            }
        }


        private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.wordDao())
                    }
                }
            }

            suspend fun populateDatabase(wordDao: WordDao) {
                // Delete all content
                wordDao.deleteAll()

                // Add sample words
                val synonymProducer: (String) -> Synonym
                synonymProducer = ::Synonym

                val wordProducer: (String, Synonym) -> Word
                wordProducer = { st, sy ->
                    Word(
                        id = null,
                        word = st,
                        synonym = sy
                    )
                }


                val word = wordProducer.invoke("Hello ", synonymProducer.invoke("World"))


                wordDao.insert(word)


            }
        }
    }
}