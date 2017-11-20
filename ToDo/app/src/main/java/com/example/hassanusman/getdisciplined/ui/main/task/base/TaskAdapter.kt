package com.example.hassanusman.getdisciplined.ui.main.task.base

import android.content.Context
import android.graphics.Paint
import android.support.design.widget.AppBarLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hassanusman.getdisciplined.App
import com.example.hassanusman.getdisciplined.R
import com.example.hassanusman.getdisciplined.data.DataManager
import com.example.hassanusman.getdisciplined.data.db.model.Task
import com.example.hassanusman.getdisciplined.utils.itemtouch.*
import kotlinx.android.synthetic.main.task_item.view.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.imageResource
import java.util.*
import javax.inject.Inject

/**
 * Created by HassanUsman on 04/10/2017.
 */
class TaskAdapter(val appBar: AppBarLayout, val recyclerView: RecyclerView, val context: Context) :
        DragableAdapter<TaskViewHolder, Task>(recyclerView) {


    init {
        (context as App).component().inject(this)
    }

    private val TAG = "TaskAdapter"


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(items[holder.adapterPosition])


        holder.itemView.setOnLongClickListener {
            onStartDragListener.onStartDrag(holder)
            false
        }

        holder.itemView.status.setOnClickListener {
            statusButtonClicked(holder)
        }
    }

    private fun statusButtonClicked(holder: TaskViewHolder) {
        val adapterPosition = holder.adapterPosition

        items[adapterPosition].status = !items[adapterPosition].status

        dataManager.updateTaskStatus(items[adapterPosition])

        holder.setStatus(items[adapterPosition])

        if(!dataManager.getFinishedTasksVisibility()) {
            items.removeAt(adapterPosition)
            notifyItemRemoved(adapterPosition)
        }
    }

    override fun getItemCount(): Int = items.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder =
            TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false))

    fun setArray(taskArray: ArrayList<Task>) {

        if (items.size > 0) {
            appBar.setExpanded(false)
        }

        items = taskArray

        notifyDataSetChanged()

        recyclerView.smoothScrollToPosition(itemCount)
    }

    override fun onItemMove(oldPos: Int, newPos: Int): Boolean {
        moveItem(oldPos, newPos)
        return true
    }

    override fun onItemSwipe(pos: Int) {
        dataManager.deleteTask(items[pos])
        items.removeAt(pos)
        notifyItemRemoved(pos)
    }


    private fun moveItem(oldPos: Int, newPos: Int) {
        notifyItemMoved(oldPos, newPos)

        val orderForOld = items[newPos].taskOrder
        val orderFolNew = items[oldPos].taskOrder

        dataManager.updateTaskOrder(items[oldPos], orderForOld)
        dataManager.updateTaskOrder(items[newPos], orderFolNew)

        items[oldPos].taskOrder = orderForOld
        items[newPos].taskOrder = orderFolNew

        Collections.swap(items, oldPos, newPos)
    }

}

class TaskViewHolder(itemView: View) : DragableHolder(itemView) {
    private val TAG = "TaskViewHolder"

    lateinit var taskClass: Task


    fun bind(_task: Task) = with(itemView) {
        task.text = _task.task

        taskClass = _task

        setStatus(taskClass)
    }

    fun setStatus(_task: Task) = with(itemView) {
        taskClass = _task

        if(taskClass.status) statusTrue() else statusFalse()
    }

     private fun statusTrue() = with(itemView) {
        task.paintFlags = task.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        status.imageResource = R.drawable.checkbox_marked_circle
    }

    private fun statusFalse() = with(itemView) {
        task.paintFlags = task.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()

        status.imageResource = R.drawable.checkbox_blank_circle_outline

    }


}