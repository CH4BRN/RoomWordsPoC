// File BaseRecyclerViewAdapter.kt
// @Author pierre.antoine - 08/01/2020 - No copyright.

package com.uldskull.roomwordsample.ui.adapter

import android.os.Handler
import android.os.Looper
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

/**
 *   Class "BasRecyclerViewAdapter" :
 *   TODO: Fill class use.
 **/
/**
 * Abstract class for RecyclerView simpleAdapter.
 */
abstract class BaseRecyclerViewAdapter<T>:
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    /**
     * Item list to display
     */
    private var list: ArrayList<T>? = ArrayList()

    /**
     * Listen to theclick on items
     */
    private var itemClickListener: AdapterView.OnItemClickListener? = null

    /**
     * Add an item to the recycler view.
     */
    fun addItems(items: ArrayList<T>){
        this.list?.addAll(items)
        reload()
    }

    /**
     * Clear the recycler view.
     */
    fun clear(){
        this.list?.clear()
        reload()
    }

    /**
     * Get an item by its position.
     */
    fun getItem(position:Int):T?{
        return this.list?.get(position)
    }

    /**
     * Set the OnClickListener that listen the click on an item.
     */
    fun setOnItemClickListener(onItemClickListener: AdapterView.OnItemClickListener){
        this.itemClickListener = onItemClickListener
    }

    /**
     * Get the count of items
     */
    override fun getItemCount(): Int = list!!.size

    /**Reload the recycler view.
     *
     */
    private fun reload(){
        Handler(Looper.getMainLooper()).post { notifyDataSetChanged()
        }
    }
}