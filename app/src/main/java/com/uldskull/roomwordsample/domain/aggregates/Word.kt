// File Word.kt
// @Author pierre.antoine - 06/01/2020 - No copyright.

package com.uldskull.roomwordsample.domain.aggregates

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uldskull.roomwordsample.domain.aggregates.synonym.Synonym
import com.uldskull.roomwordsample.infrastructure.data.word.DatabaseContract
import com.uldskull.roomwordsample.infrastructure.data.word.DatabaseContract.WordDatabaseEntries.Companion.WORD_TABLE_NAME


/**
 *   Class "Word" :
 *   This class will describe the Entity (which represents the SQLite table) for your words.
 *   Each public property in the class represents a column in the table.
 *   Room will ultimately use these properties to both create the table and instantiate
 *   objects from rows in the database.
 *
 *   . The class should be annotated with Entity, this is how Room identifies, For each entity
 *   you create, a table is created with the associated Database. By default, Room creates a
 *   column for each field, but you can avoid this for few fields by using Ignore annotation.
 *
 *   . Each Entity, must define at least 1 primary key. You need to annotate the field with
 *   PrimaryKey annotation.
 *
 *   . By default Room uses the class name as the table name. You can give custom name by using
 *   tableName property.
 *
 **/
@Entity(tableName = WORD_TABLE_NAME)
data class Word(

    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = DatabaseContract.WordDatabaseEntries.COLUMN_WORD)
    val word: String,
    @Embedded
    val synonym: Synonym
)
