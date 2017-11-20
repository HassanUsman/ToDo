package com.example.hassanusman.getdisciplined.ui.base

import io.reactivex.Observable

/**
 * Created by HassanUsman on 10/09/2017.
 */
interface MvpPresenter<V : MvpView> {
    fun onAttach(mvpView: V)

    fun onDetach()

}

