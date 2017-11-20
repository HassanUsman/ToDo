package com.example.hassanusman.getdisciplined.ui.main.task.add

import com.example.hassanusman.getdisciplined.ui.base.MvpPresenter

/**
 * Created by HassanUsman on 10/10/2017.
 */
interface AddMvpPresenter<V: AddMvpView> : MvpPresenter<V> {
//    fun addTask(taskText: String, listId: Long?, operation: () -> Unit)
    fun addTaskToday(taskText: String, operation: () -> Unit)
    fun addTaskToDo(taskText: String, operation: () -> Unit)
    fun addTaskListId(taskText: String, listId: Long,  operation: () -> Unit)
}