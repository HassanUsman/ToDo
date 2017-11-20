package com.example.hassanusman.getdisciplined.ui.main.task.add

import com.example.hassanusman.getdisciplined.ui.base.MvpView

/**
 * Created by HassanUsman on 10/10/2017.
 */
interface AddMvpView: MvpView {
    fun setFragment()

    fun clearEditText()

    fun addTaskAction()
}