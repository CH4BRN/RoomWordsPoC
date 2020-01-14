// File MatchDao.kt
// @Author errei - 13/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.dao

import androidx.room.*
import com.uldskull.roomwordsample.RelationExperiment.model.Match

/**
 *   Class "MatchDao" :
 *   TODO: Fill class use.
 **/
@Dao
interface MatchDao {

    /* MATCH */

    @Insert
    fun insertMatch(match: Match) : Long

    @Insert
    fun insertMatches(matches: List<Match>) : List<Long>

    @Insert
    fun insertMatches(vararg  matches: Match)

    @Update
    fun updateMatch(match: Match)

    @Delete
    fun deleteMatch(match: Match)

    @Query("SELECT * FROM `match`")
    fun getAllMatches(): List<Match>
// TODO : Fill class.
}