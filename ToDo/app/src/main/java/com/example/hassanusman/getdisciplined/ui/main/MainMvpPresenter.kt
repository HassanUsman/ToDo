package com.example.hassanusman.getdisciplined.ui.main

import com.example.hassanusman.getdisciplined.di.PerActivity
import com.example.hassanusman.getdisciplined.ui.base.MvpPresenter

/**
 * Created by HassanUsman on 18/09/2017.
 */
@PerActivity
interface MainMvpPresenter<V : MainMvpView> : MvpPresenter<V> {
    fun onDrawerClick()

    fun onAddListId()

    fun navigationListIds()


}