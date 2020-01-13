// File Score.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 *   Class "Score" :
 *   TODO: Fill class use.
 **/
@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Match::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("matchId"),
        //  onDelete = ForeignKey.CASCADE qui supprimera les Score associés à un Match si ce
        //  dernier est supprimé de la base de données
        onDelete = ForeignKey.CASCADE))
)
class Score(var label:String, var  scoreTeam1: Int, var scoreteam2: Int, var matchId: Long) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}