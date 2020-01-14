// File PlayerListAdapter.kt
// @Author pierre.antoine - 14/01/2020 - No copyright.

package com.uldskull.roomwordsample.RelationExperiment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uldskull.roomwordsample.R
import com.uldskull.roomwordsample.RelationExperiment.model.Player

/**
 *   Class "PlayerListAdapter" :
 *   TODO: Fill class use.
 **/
class PlayerListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<PlayerListAdapter.PlayerViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)


    private var players = emptyList<Player>()

    inner class  PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val playerItemView: TextView = itemView.findViewById(R.id.textView_player)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val itemView = inflater.inflate(R.layout.player_recyclerview_item, parent, false)
        return PlayerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val current = players[position]
        holder.playerItemView.text = current.name
    }

    internal fun setPlayers(players: List<Player>){
        this.players = players
        notifyDataSetChanged()
    }

    fun getItem(position: Int) : Player?{
        return this.players[position]
    }

    override fun getItemCount(): Int {
        return players.size
    }
// TODO : Fill class.
}