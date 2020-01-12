// File Team.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.NO_ACTION
import androidx.room.PrimaryKey

/**
 *   Class "Team" :
 *   TODO: Fill class use.
 **/
@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Coach::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("coachId"),
        onDelete = NO_ACTION))
)
class Team(var name: String, var coachId: Long,
           @Embedded
           var address: Address){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

}