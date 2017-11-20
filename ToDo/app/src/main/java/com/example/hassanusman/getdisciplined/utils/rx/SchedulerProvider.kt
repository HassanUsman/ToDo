package com.example.hassanusman.getdisciplined.utils.rx

import io.reactivex.Scheduler

/**
 * Created by HassanUsman on 10/09/2017.
 */
interface SchedulerProvider {
    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler
}