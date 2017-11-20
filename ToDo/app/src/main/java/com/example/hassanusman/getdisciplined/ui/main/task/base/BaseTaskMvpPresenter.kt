package com.example.hassanusman.getdisciplined.ui.main.task.base

import com.example.hassanusman.getdisciplined.ui.base.MvpPresenter

/**
 * Created by HassanUsman on 11/10/2017.
 */
interface BaseTaskMvpPresenter<V: BaseTaskMvpView> : MvpPresenter<V> {
    fun isTodayExist()

    fun getTasks(dateId: Long)

    fun getTasksVisibility()

    fun changeTaskVisibility()
}