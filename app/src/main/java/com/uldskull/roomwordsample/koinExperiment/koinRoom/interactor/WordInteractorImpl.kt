// File WordInteractorImpl.kt
// @Author pierre.antoine - 15/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.koinRoom.interactor

import android.database.Observable
import com.uldskull.roomwordsample.domain.aggregates.Word
import com.uldskull.roomwordsample.koinExperiment.koinRoom.repository.KoinWordRepository

/**
 *   Class "WordInteractorImpl" :
 *   TODO: Fill class use.
 **/
class WordInteractorImpl(private val koinWordRepository: KoinWordRepository) : WordInteractor {

    override fun insert(word: Word) {
        koinWordRepository.insert(word)
    }

    override fun update(word: Word) {
        koinWordRepository.update(word)
    }

    override fun delete(word: Word) {
        koinWordRepository.delete(word)
    }

    override fun deleteAll() {
        koinWordRepository.deleteAllWords()
    }

    override fun getAll(): Observable<List<Word>> {
        return koinWordRepository.getAllWord()
    }
// TODO : Fill class.
}