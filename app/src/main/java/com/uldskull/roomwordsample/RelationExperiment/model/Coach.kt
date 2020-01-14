// File Coach.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.model

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 *   Class "Coach" :
 *   TODO: Fill class use.
 **/
@Entity
class Coach(name:String,
            @ColumnInfo(name = "xp")
            var experience:Int):User(name) {
// TODO : Fill class.
}