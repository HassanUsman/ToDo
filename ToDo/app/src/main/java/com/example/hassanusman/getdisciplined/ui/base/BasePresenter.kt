package com.example.hassanusman.getdisciplined.ui.base

import com.example.hassanusman.getdisciplined.data.DataManager
import com.example.hassanusman.getdisciplined.utils.rx.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by HassanUsman on 11/09/2017.
 */
open class BasePresenter<V : MvpView> @Inject
constructor(var dataManager: DataManager,
            var schedulerProvider: SchedulerProvider?,
            var compositeDisposable: CompositeDisposable?) : MvpPresenter<V> {

    var mvpView: V? = null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        compositeDisposable?.dispose()
        mvpView = null
    }
}