// File WordViewModel.kt
// @Author pierre.antoine - 06/01/2020 - No copyright.

package com.uldskull.roomwordsample.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.uldskull.roomwordsample.RelationExperiment.database.MyDatabase
import com.uldskull.roomwordsample.RelationExperiment.model.Player
import com.uldskull.roomwordsample.domain.aggregates.Word
import com.uldskull.roomwordsample.infrastructure.data.word.WordRepository
import com.uldskull.roomwordsample.infrastructure.data.word.WordRoomDatabase
import kotlinx.coroutines.launch

/**
 *   Class "WordViewModel" :
 *   Class extends AndroidViewModel and requires application as a parameter.
 *   If you need the application context (which has a lifecycle that lives as
 *   long as the application does), use AndroidViewModel, as shown in this codelab.
 *
 **/
class WordViewModel(application: Application) :AndroidViewModel(application) {
    // The ViewModel maintains a reference to the repository to get data.
    private val repository: WordRepository



    // LiveData gives us updated words when they change. Cache the list of words.
    val allWords: LiveData<List<Word>>?

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository
        //   also pass the scope.
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope)?.wordDao()

        repository =
            WordRepository(
                wordsDao
            )
        allWords = repository.allWords


        WordViewModel.database = Room.databaseBuilder(
            application,
            MyDatabase::class.java,
            "championship-db" )
            .build()


    }

    /**
     * The implementation of insert() in the database is completely hidden from the UI.
     * Room ensures that you're not doing any long running operations on
     * the main thread, blocking the UI, so we don't need to handle changing Dispatchers.
     * ViewModels have a coroutine scope based on their lifecycle called
     * viewModelScope which we can use here.
     */
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }


    fun createPlayer(name:String, position: String, avatar:String): Player{
        var player = Player(name, position, null)
        player.avatar = avatar
        player.id = WordViewModel.database?.userDao()?.insertPlayer(player)
        return player
    }


    fun getPlayers():List<Player>{
        var players = WordViewModel.database?.userDao()?.getAllPlayer()
        if (players != null) {
            return players
        }
        return emptyList()
    }

    companion object{
        var database: MyDatabase? = null
    }
}