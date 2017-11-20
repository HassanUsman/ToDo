package com.example.hassanusman.getdisciplined.utils.itemtouch

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.example.hassanusman.getdisciplined.App
import com.example.hassanusman.getdisciplined.R
import com.example.hassanusman.getdisciplined.data.DataManager
import com.example.hassanusman.getdisciplined.ui.main.task.base.TaskViewHolder
import javax.inject.Inject

/**
 * Created by HassanUsman on 09/11/2017.
 */
abstract class DragableAdapter<T : DragableHolder, L: Any>
    (private val recyclerView: RecyclerView)
        : RecyclerView.Adapter<T>(), ItemTouchHelperAdapter, OnStartDragListener  {

    var items = ArrayList<L>()

    var onDrag = false

    @Inject lateinit var dataManager: DataManager

    private var callback = ItemTouchHelperCallback(this)
    var itemTouchHelper = ItemTouchHelper(callback)
    var onStartDragListener: OnStartDragListener = this

    init {
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    override fun onStopDrag(viewHolder: RecyclerView.ViewHolder) {
        (viewHolder as DragableHolder).changeBackground(android.R.color.white)
        onDrag = false
    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
        itemTouchHelper.startDrag(viewHolder)
        (viewHolder as DragableHolder).changeBackground(R.color.colorPrimaryLight)
        onDrag = true
    }


}