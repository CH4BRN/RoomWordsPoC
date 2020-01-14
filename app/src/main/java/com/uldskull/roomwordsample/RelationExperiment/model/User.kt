// File User.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.model

import androidx.room.PrimaryKey

/**
 *   Class "User" :
 *   TODO: Fill class use.
 **/
abstract class User(var name:String){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}