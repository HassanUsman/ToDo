package com.example.hassanusman.getdisciplined.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hassanusman.getdisciplined.App
import com.example.hassanusman.getdisciplined.R
import com.example.hassanusman.getdisciplined.data.db.model.ListId
import com.example.hassanusman.getdisciplined.utils.itemtouch.*
import kotlinx.android.synthetic.main.listid_item.view.*
import java.util.*

/**
 * Created by HassanUsman on 03/11/2017.
 */
class ListAdapter(val context: Context, recyclerView: RecyclerView) :
    DragableAdapter<ListViewHolder, ListId>(recyclerView) {

    private val TAG = "ListAdapter"

    lateinit var callback: Callback

    init {
        (context as App).component().inject(this)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        if(position < 2) {
            when(position) {
                0 -> {
                    holder.bind2(context.resources.getString(R.string.myday), R.drawable.myday)
                }
                1 -> {
                    holder.bind2(context.resources.getString(R.string.todo), R.drawable.todo)
                }
            }
        } else {
            holder.bind(items[position])
        }

        holder.itemView.setOnClickListener {
            if(position < 2) {
                callback.clickedTodayOrToDoItem(position)
            } else {
                callback.clickedNavigationItem(items[holder.adapterPosition])
            }
        }

        holder.itemView.setOnLongClickListener {
            onStartDragListener.onStartDrag(holder)
            false
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListViewHolder =
            ListViewHolder(LayoutInflater.from(context).inflate(R.layout.listid_item, parent, false))

    fun updateArray(array: ArrayList<ListId>) {
        if(!onDrag) {
            items = array

            items.add(0, ListId(0, context.resources.getString(R.string.todo), 0))
            items.add(0, ListId(0, context.resources.getString(R.string.myday), 0))

            notifyDataSetChanged()
        }
    }



    override fun onItemMove(oldPos: Int, newPos: Int): Boolean {
        moveItem(oldPos, newPos)
        return true
    }

    override fun onItemSwipe(pos: Int) {

    }

    private fun moveItem(oldPos: Int, newPos: Int) {
        if(oldPos >= 2 && newPos >= 2) {
            notifyItemMoved(oldPos, newPos)

            val orderForOld = items[newPos].listOrder
            val orderFolNew = items[oldPos].listOrder

            val task1 = items[oldPos]
            task1.listOrder = orderForOld
            dataManager.updateListId(task1)

            val task2 = items[newPos]
            task1.listOrder = orderFolNew
            dataManager.updateListId(task2)

            items[oldPos].listOrder = orderForOld
            items[newPos].listOrder = orderFolNew

            Collections.swap(items, oldPos, newPos)
        }
    }


    interface Callback {
        fun clickedTodayOrToDoItem(position: Int)

        fun clickedNavigationItem(listId: ListId)
    }
}

class ListViewHolder(itemView: View) : DragableHolder(itemView) {
    lateinit var _listId: ListId

    fun bind(listId: ListId) = with(itemView) {
        text.text = listId.name

        _listId = listId
    }

    fun bind2(name: String, imageId: Int) = with(itemView) {
        image.setImageResource(imageId)
        text.text = name
    }
}