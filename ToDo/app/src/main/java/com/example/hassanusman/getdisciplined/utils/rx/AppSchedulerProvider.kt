package com.example.hassanusman.getdisciplined.utils.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by HassanUsman on 10/09/2017.
 */
class AppSchedulerProvider : SchedulerProvider {
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()

    override fun computation(): Scheduler = Schedulers.computation()

    override fun io(): Scheduler = Schedulers.io()
}