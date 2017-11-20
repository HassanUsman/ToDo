package com.example.hassanusman.getdisciplined.ui.main.task.base

import com.example.hassanusman.getdisciplined.data.db.model.Task
import com.example.hassanusman.getdisciplined.ui.base.MvpView

/**
 * Created by HassanUsman on 11/10/2017.
 */
interface BaseTaskMvpView : MvpView {
    fun showAddTaskView()

    fun hideAddTaskView()

    fun updateTasksList(array: ArrayList<Task>)

    fun setToolbar(title: String)

    fun <V: BaseTaskMvpView> setFragment(presenter: BaseTaskPresenter<V>)

    fun updateTasksVisibilityIcon(visibility: Boolean)
}