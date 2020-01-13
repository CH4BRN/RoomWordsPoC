// File SportRepository.kt
// @Author pierre.antoine - 13/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.repository

import androidx.lifecycle.LiveData
import com.uldskull.roomwordsample.RelationExperiment.dao.UserDao
import com.uldskull.roomwordsample.RelationExperiment.model.Player
import com.uldskull.roomwordsample.RelationExperiment.model.User

/**
 *   Class "SportRepository" :
 *   TODO: Fill class use.
 **/
class PlayerRepository (private val userDao:UserDao?){

    val allPlayers: LiveData<List<Player>>? = userDao?.getAllPlayer()


    suspend fun insert(player: Player){
        userDao?.insertPlayer(player)
    }
}