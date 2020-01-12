// File DatabaseDataHolder.kt
// @Author errei - 12/01/2020 - No copyright.

package com.uldskull.roomwordsample.infrastructure.data.word.relations

import androidx.room.Entity
import androidx.room.ForeignKey
import com.uldskull.roomwordsample.domain.aggregates.Word
import com.uldskull.roomwordsample.domain.aggregates.metaData.WordMetaData

/**
 *   Class "DatabaseDataHolder" :
 *   TODO: Fill class use.
 **/
class DatabaseDataHolder {

    @Entity(
        primaryKeys = ["word", "metadata"], foreignKeys = [
        ForeignKey(
            entity = Word::class,
            parentColumns = ["id"],
            childColumns = ["word"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = WordMetaData::class,
            parentColumns = ["id"],
            childColumns = ["metadata"],
            onDelete = ForeignKey.CASCADE
        )]
    )

    class AssignedMetadata{
        var word: Int? = 0
        var metadata: Int? = 0

    }
// TODO : Fill class.
}