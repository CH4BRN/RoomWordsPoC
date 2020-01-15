// File WordPresenter.kt
// @Author pierre.antoine - 15/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.koinRoom.presenter

import androidx.lifecycle.LiveData
import com.uldskull.roomwordsample.domain.aggregates.Word

/**
 *   Interface "WordPresenter" :
 *   TODO: Fill interface use.
 **/
interface WordPresenter {
    fun insert(word: Word)

    fun update(word: Word)

    fun delete(word: Word)

    fun deleteAllWords()

    fun getAllWords(): LiveData<List<Word>>

    fun loadWords()
// TODO : Fill interface.
}