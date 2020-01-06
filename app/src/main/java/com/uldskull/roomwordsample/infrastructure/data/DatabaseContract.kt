package com.uldskull.roomwordsample.infrastructure.data

import android.provider.BaseColumns

object DatabaseContract {
    class WordDatabaseEntries : BaseColumns{
        companion object{
            const val DATABASE_NAME = "word_database"
           const val TABLE_NAME = "word_table"
            const val COLUMN_WORD = "word"


        }

    }
}