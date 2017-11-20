package com.example.hassanusman.getdisciplined.utils.itemtouch

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.task_item.view.*
import org.jetbrains.anko.backgroundColor

/**
 * Created by HassanUsman on 09/11/2017.
 */
abstract class DragableHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun changeBackground(color: Int) = with(itemView)  {
        parentRL.backgroundColor = ContextCompat.getColor(context, color)
    }
}