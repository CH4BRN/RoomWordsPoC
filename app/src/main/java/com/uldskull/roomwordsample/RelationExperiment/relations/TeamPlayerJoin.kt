// File TeamPlayerJoin.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.relations

import androidx.room.Entity
import androidx.room.ForeignKey
import com.uldskull.roomwordsample.RelationExperiment.model.Player
import com.uldskull.roomwordsample.RelationExperiment.model.Team

/**
 *   Class "TeamPlayerJoin" :
 *   TODO: Fill class use.
 **/
@Entity(tableName = "team_player_join",
    primaryKeys =  arrayOf("teamId",  "playerId" ),
    foreignKeys = arrayOf(
        ForeignKey(entity = Team::class,
                parentColumns = ["id"],
            childColumns = ["teamId"]),
        ForeignKey(entity = Player::class,
                parentColumns = ["id"],
            childColumns = ["playerId"])
    ))
class TeamPlayerJoin(val teamId: Long, val playerId: Long)