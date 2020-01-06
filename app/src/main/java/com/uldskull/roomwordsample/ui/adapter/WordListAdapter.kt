// File WordListAdapter.kt
// @Author pierre.antoine - 06/01/2020 - No copyright.

package com.uldskull.roomwordsample.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uldskull.roomwordsample.R
import com.uldskull.roomwordsample.domain.Word

/**
 *   Class "WordListAdapter" :
 *   TODO: Fill class use.
 **/
class WordListAdapter internal constructor(
    context: Context
): RecyclerView.Adapter<WordListAdapter.WordViewHolder>(){

    /**
     * inflater
     */
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<Word>()

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val wordItelmView : TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView  = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current =words[position]
        holder.wordItelmView.text = current.word
    }

    internal fun setWords(words:List<Word>){
        this.words = words
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = words.size
}