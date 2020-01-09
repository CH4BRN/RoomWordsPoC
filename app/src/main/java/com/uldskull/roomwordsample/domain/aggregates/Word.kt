// File Word.kt
// @Author pierre.antoine - 06/01/2020 - No copyright.

package com.uldskull.roomwordsample.domain.aggregates

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uldskull.roomwordsample.infrastructure.data.word.DatabaseContract
import com.uldskull.roomwordsample.infrastructure.data.word.DatabaseContract.WordDatabaseEntries.Companion.WORD_TABLE_NAME


/**
 *   Class "Word" :
 *   This class will describe the Entity (which represents the SQLite table) for your words.
 *   Each public property in the class represents a column in the table.
 *   Room will ultimately use these properties to both create the table and instantiate
 *   objects from rows in the database.
class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)
 **/
@Entity(tableName = WORD_TABLE_NAME)
data class Word(

    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = DatabaseContract.WordDatabaseEntries.COLUMN_WORD)
    val word: String,
    @Embedded
    val synonym: Synonym)
