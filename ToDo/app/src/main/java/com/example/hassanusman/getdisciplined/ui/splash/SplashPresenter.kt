package com.example.hassanusman.getdisciplined.ui.splash

import com.example.hassanusman.getdisciplined.data.DataManager
import com.example.hassanusman.getdisciplined.ui.base.BasePresenter
import com.example.hassanusman.getdisciplined.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Created by HassanUsman on 11/09/2017.
 */
class SplashPresenter<V : SplashMvpView> @Inject
constructor(dataManager: DataManager,
            schedulerProvider: SchedulerProvider?,
            compositeDisposable: CompositeDisposable?) :
        BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable), SplashMvpPresenter<V>{

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)

        mvpView.openMainActivity()
    }



}

