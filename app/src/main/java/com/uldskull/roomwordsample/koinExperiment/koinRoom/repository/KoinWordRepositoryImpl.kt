// File KoinWordRepositoryImpl.kt
// @Author pierre.antoine - 15/01/2020 - No copyright.

package com.uldskull.roomwordsample.koinExperiment.koinRoom.repository

import android.database.Observable
import android.util.Log
import com.uldskull.roomwordsample.domain.aggregates.Word
import com.uldskull.roomwordsample.infrastructure.data.word.WordDao
import com.uldskull.roomwordsample.koinExperiment.koinRoom.dao.KoinWordDao
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *   Class "KoinWordRepositoryImpl" :
 *   TODO: Fill class use.
 **/
class KoinWordRepositoryImpl(private val wordDao: KoinWordDao) : KoinWordRepository{

    override fun insert(word: Word) {
        wordDao.insert(word)

    }

    override fun delete(word: Word) {
        wordDao.deleteOne(word)
    }

    override fun deleteAllWords() {
        wordDao.deleteAll()
    }

    override fun getAllWord(): Observable<List<Word>> {
        return wordDao.getAlphabetizedWords()
    }

    override fun update(word: Word) {
        wordDao.update(word)
    }
// TODO : Fill class.
}