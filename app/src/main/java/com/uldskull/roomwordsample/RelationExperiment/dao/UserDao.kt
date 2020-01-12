package com.uldskull.roomwordsample.RelationExperiment.dao

import androidx.room.*
import com.uldskull.roomwordsample.RelationExperiment.model.Player
@Dao
interface UserDao {
    /* PLAYER */

    @Insert
    fun insertPlayer(player: Player) : Long

    @Insert
    fun insertPlayers(players: List<Player>) : List<Long>

    @Insert
    fun insertPlayers(vararg players: Player)
    @Update
    fun updatePlayer(player: Player)


    @Delete
    fun deletePlayer(player: Player)


    @Query("SELECT * FROM players")
    fun getAllPlayer(): List<Player>

    @Query("SELECT * FROM players WHERE id=:playerId")
    fun getPlayer(playerId: Long) : Player
}