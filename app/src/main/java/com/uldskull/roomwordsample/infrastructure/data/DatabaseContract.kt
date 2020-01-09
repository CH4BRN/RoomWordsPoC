package com.uldskull.roomwordsample.infrastructure.data

import android.provider.BaseColumns

/**
 * Data for database
 */
object DatabaseContract {
    /**
     * Entries for word database
     */
    class WordDatabaseEntries : BaseColumns {
        companion object {
            /**
             * Database name.
             */
            const val DATABASE_NAME = "word_database"
            /**
             * Table name.
             */
            const val TABLE_NAME = "word_table"
            /**
             * Column name.
             */
            const val COLUMN_WORD = "word"


        }

    }
}