// File Match.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

/**
 *   Class "Match" :
 *   TODO: Fill class use.
 **/
@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Team::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("firstTeamId"),
        onDelete = ForeignKey.NO_ACTION),
    ForeignKey(entity = Team::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("secondTeamId"),
        onDelete = ForeignKey.NO_ACTION))
)
class Match(var date:Date, var firstTeamId: Long, var secondTeamId: Long) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
// TODO : Fill class.
}