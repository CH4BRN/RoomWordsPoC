package com.uldskull.roomwordsample.RelationExperiment.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.uldskull.roomwordsample.RelationExperiment.model.Player
@Dao
interface UserDao {
    /* PLAYER */

    /**
     * @Insert: Persister un objet en base de données. L’annotation permet à la méthode de pouvoir
     * retourner l’identifiant (Long, si autoGenerate=true) de l’objet en base, ou une liste
     * d’identifiant List<Long> (ou long[ ] ) dans le cas d’une persistance multiple. Je vous
     * ai volontairement présenté les trois façons de définir une persistance pour l’ajout, vous
     * pourrez définir les méthodes suivantes (update et delete) de la même façon.
     */
    @Insert
    fun insertPlayer(player: Player) : Long

    @Insert
    fun insertPlayers(players: List<Player>) : List<Long>

    @Insert
    fun insertPlayers(vararg players: Player)

    /**
     * @Update: Mise à jour d’un objet persisté. L’annotation permet de retourner le nombre (int)
     * de ligne mise à jour.
     */
    @Update
    fun updatePlayer(player: Player)

    /**
     * @Delete: Suppression d’un objet persisté. l’annotation permet de retourner le nombre (int)
     * de ligne supprimée.
     */
    @Delete
    fun deletePlayer(player: Player)



    /**
     * @Query(« requête »): Opération de lecture d’enregistrement via la définition de requête SQL.
     * Le type retourné peut être, par exemple, un Player, une List<Player> ou même un Cursor
     */
    @Query("SELECT * FROM players")
    fun getAllPlayer(): LiveData<List<Player>>

    @Query("SELECT * FROM players WHERE id=:playerId")
    fun getPlayer(playerId: Long) : Player

    @Query("DELETE FROM players")
    suspend fun deleteAll()
}