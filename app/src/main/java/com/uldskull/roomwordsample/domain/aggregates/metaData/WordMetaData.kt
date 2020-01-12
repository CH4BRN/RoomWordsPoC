// File WordMetaData.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.domain.aggregates.metaData

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *   Class "WordMetaData" :
 *   TODO: Fill class use.
 **/
@Entity
data class WordMetaData (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val wordInfo:String
)