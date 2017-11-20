package com.example.hassanusman.getdisciplined.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by HassanUsman on 19/09/2017.
 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var currentPosition: Int? = null

    abstract fun clear()

    fun onBind(position: Int) {
        currentPosition = position

        clear()
    }
}