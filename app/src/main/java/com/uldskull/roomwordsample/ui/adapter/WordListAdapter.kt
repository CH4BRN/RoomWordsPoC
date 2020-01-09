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
 *   Adapter for word list recycler view.
 **/
class WordListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    /**
     * inflater
     */
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    /**
     * Word list
     */
    private var words = emptyList<Word>()

    /**
     * View holder.
     */
    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView_word)
        val idItemView: TextView = itemView.findViewById(R.id.textView_id)
    }

    /**
     * ViewHolder Lifecycle.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        //  Load a recycler view item.
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    /**
     * Bind the view holder to data.
     */
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words[position]
        holder.wordItemView.text = current.word
        holder.idItemView.text = current.id.toString()
    }

    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Word? {
        return this.words[position]
    }

    override fun getItemCount(): Int = words.size
}