// File TeamAllPlayers.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.uldskull.roomwordsample.RelationExperiment.model.Player
import com.uldskull.roomwordsample.RelationExperiment.model.Team

/**
 *   Class "TeamAllPlayers" :
 *   TODO: Fill class use.
 **/
class TeamAllPlayers {

    @Embedded
    var team: Team? = null

    @Relation(parentColumn = "id", entityColumn = "teamId")
    var players: List<Player>? = null
// TODO : Fill class.
}