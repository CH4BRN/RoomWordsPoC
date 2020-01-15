// File KoinWordRepository.kt
// @Author pierre.antoine - 15/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.koinRoom.repository

import android.database.Observable
import com.uldskull.roomwordsample.domain.aggregates.Word

/**
 *   Interface "KoinWordRepository" :
 *   TODO: Fill interface use.
 **/
interface KoinWordRepository {

    fun insert(word:Word)

    fun update(word: Word)

    fun delete(word: Word)

    fun deleteAllWords()

    fun getAllWord(): Observable<List<Word>>
// TODO : Fill interface.
}