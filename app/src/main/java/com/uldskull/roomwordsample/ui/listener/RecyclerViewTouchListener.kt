// File RecyclerViewTouchListener.kt
// @Author pierre.antoine - 08/01/2020 - No copyright.

package com.uldskull.roomwordsample.ui.listener

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.RecyclerView
import com.uldskull.roomwordsample.fragment_list

/**
 *   Class "RecyclerViewTouchListener" :
 *   TODO: Fill class use.
 **/
class RecyclerViewTouchListener (
    context: Context,
    recyclerView: RecyclerView,
    private val clickListener: fragment_list.ClickListener?
) : RecyclerView.OnItemTouchListener {
    private val gestureDetector: GestureDetector

    init {
        gestureDetector =
            GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    return true
                }

                override fun onLongPress(e: MotionEvent) {
                    val child = recyclerView.findChildViewUnder(e.x, e.y)
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child))
                    }
                }


            })
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {

        val child = rv.findChildViewUnder(e.x, e.y)
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildPosition(child))
        }
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }

}
