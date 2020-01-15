// File WordPresenterImpl.kt
// @Author pierre.antoine - 15/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.koinRoom.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uldskull.roomwordsample.domain.aggregates.Word
import com.uldskull.roomwordsample.koinExperiment.koinRoom.interactor.WordInteractor

/**
 *   Class "WordPresenterImpl" :
 *   TODO: Fill class use.
 **/
class WordPresenterImpl(private val  wordInteractor: WordInteractor) : WordPresenter {

    private val allWords : MutableLiveData<List<Word>> = MutableLiveData()

    init{
        loadWords()
    }

    override fun insert(word: Word) {
        wordInteractor.insert(word)
    }

    override fun update(word: Word) {
        wordInteractor.update(word)
    }

    override fun delete(word: Word) {
        wordInteractor.delete(word)
    }

    override fun deleteAllWords() {
        wordInteractor.deleteAll()
    }

    override fun getAllWords(): LiveData<List<Word>> {
        return  allWords
    }

    override fun loadWords() {
        wordInteractor.getAll()

    }


// TODO : Fill class.
}