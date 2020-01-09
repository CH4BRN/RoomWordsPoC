package com.uldskull.roomwordsample.infrastructure.data.word

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
            const val WORD_TABLE_NAME = "word_table"
            /**
             * Column name.
             */
            const val COLUMN_WORD = "word"
        }
    }
}