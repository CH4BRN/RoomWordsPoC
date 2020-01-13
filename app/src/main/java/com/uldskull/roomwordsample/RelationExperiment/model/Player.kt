// File Player.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.model

import androidx.room.Entity
import androidx.room.Ignore

/**
 *   Class "Player" :
 *   TODO: Fill class use.
 **/
@Entity(tableName = "players")
class Player (name:String, var position: String,
              var firstTeamId: Long?
):User(name){
    @Ignore
    lateinit var avatar : String
// TODO : Fill class.
}