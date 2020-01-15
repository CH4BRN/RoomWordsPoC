// File WordInteractor.kt
// @Author pierre.antoine - 15/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.koinRoom.interactor

import android.database.Observable
import com.uldskull.roomwordsample.domain.aggregates.Word

/**
 *   Class "WordInteractor" :
 *   TODO: Fill class use.
 **/
interface WordInteractor {

    fun insert(word: Word)

    fun update(word: Word)

    fun delete(word: Word)

    fun deleteAll()

    fun getAll(): Observable<List<Word>>
// TODO : Fill class.
}