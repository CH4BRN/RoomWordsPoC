// File WordRepository.kt
// @Author pierre.antoine - 06/01/2020 - No copyright.

package com.uldskull.roomwordsample.infrastructure.data.word

import androidx.lifecycle.LiveData
import com.uldskull.roomwordsample.domain.aggregates.Word

/**
 *   Class "WordRepository" :
 *   A Repository manages queries and allows you to use multiple backends.
 *   In the most common example, the Repository implements the logic for deciding whether
 *   to fetch data from a network or use results cached in a local database.
 **/
//  The DAO is passed into the repository constructor as opposed to the whole database.
//  This is because it only needs access to the DAO, since the DAO contains all the
//  read/write methods for the database. There's no need to expose the entire database
//  to the repository.
class WordRepository (private val wordDao: WordDao?){

    /**
     * The list of words is a public property. It's initialized by getting the LiveData
     * list of words from Room; we can do this because of how we defined the
     * getAlphabetizedWords method to return LiveData in the "The LiveData class" step.
     * Room executes all queries on a separate thread. Then observed LiveData will notify
     * the observer on the main thread when the data has changed.
     */
    val allWords: LiveData<List<Word>>? = wordDao?.getAlphabetizedWords()

    /**
     * The suspend modifier tells the compiler that this needs to be called from a
     * coroutine or another suspending function.
     */
    suspend fun insert(word: Word){
        wordDao?.insert(word)
    }
}