// File WordDao.kt
// @Author pierre.antoine - 06/01/2020 - No copyright.

package com.uldskull.roomwordsample.infrastructure.data.word

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uldskull.roomwordsample.domain.aggregates.Word

/**
 *   Interface "WordDao" :
 *   Interface used to access database.
 *
 *   . By accessing a database using a DAO instead of a query builder or direct queries, you
 *   can separate out different components of your database architecture.
 *
 *   . DAO allows you to easily mock database access as your test app.
 *
 *   . A DAO can be either an interface or an abstract class. In case of an abstract class,
 *   it can optionally have an constructor that takes RoomDatabase as its only parameter.
 *
 *   This DAO include nested entities.
 **/
@Dao
interface WordDao {
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

}