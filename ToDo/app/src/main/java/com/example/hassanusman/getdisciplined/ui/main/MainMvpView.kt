package com.example.hassanusman.getdisciplined.ui.main

import android.support.v4.app.Fragment
import com.example.hassanusman.getdisciplined.data.db.model.ListId
import com.example.hassanusman.getdisciplined.ui.base.MvpView

/**
 * Created by HassanUsman on 18/09/2017.
 */
interface MainMvpView : MvpView {
    fun setTaskFragment(fragment: Fragment)

    fun openDrawer()

    fun closeDrawer()

    fun updateNavigationArray(array: ArrayList<ListId>)

    fun showListIdNameDialog(listId: ListId)

}