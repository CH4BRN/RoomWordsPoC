// File SportViewModel.kt
// @Author pierre.antoine - 13/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.uldskull.roomwordsample.RelationExperiment.database.MyDatabase
import com.uldskull.roomwordsample.RelationExperiment.model.Player
import com.uldskull.roomwordsample.RelationExperiment.repository.PlayerRepository
import kotlinx.coroutines.launch

/**
 *   Class "SportViewModel" :
 *   TODO: Fill class use.
 **/
class PlayerViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PlayerRepository

    val allPlayers: LiveData<List<Player>>?

    init {
        val userDao = MyDatabase.getDatabase(application, viewModelScope)?.userDao()

        repository =
            PlayerRepository(
                userDao
            )

        allPlayers = repository.allPlayers


    }



    fun insert(player: Player) = viewModelScope.launch {
        repository.insert(player)
    }

    companion object{
        var database: MyDatabase? = null
    }


// TODO : Fill class.
}