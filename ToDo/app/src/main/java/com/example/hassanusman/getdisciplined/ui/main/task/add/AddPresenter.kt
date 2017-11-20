package com.example.hassanusman.getdisciplined.ui.main.task.add

import android.util.Log
import com.example.hassanusman.getdisciplined.R
import com.example.hassanusman.getdisciplined.data.DataManager
import com.example.hassanusman.getdisciplined.data.db.model.Date
import com.example.hassanusman.getdisciplined.ui.base.BasePresenter
import com.example.hassanusman.getdisciplined.utils.AppUtils
import com.example.hassanusman.getdisciplined.utils.rx.SchedulerProvider
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import javax.inject.Inject

/**
 * Created by HassanUsman on 10/10/2017.
 */
class AddPresenter<V: AddMvpView> @Inject
    constructor(dataManager: DataManager,
                schedulerProvider: SchedulerProvider,
                compositeDisposable: CompositeDisposable) :
    BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable), AddMvpPresenter<V>{

    private val TAG = "AddPresenter"

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)

        mvpView.setFragment()
    }

    override fun addTaskToday(taskText: String, operation: () -> Unit) {
        Observable.fromCallable {
            dataManager.getDateId(AppUtils.getToday())
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {

                    Log.d(TAG, "$it - ${it[0].id}")
                    Single.fromCallable {  dataManager.addTaskToDoAndToday(it[0].id, taskText.trim())}
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe ({operation()}, Throwable::printStackTrace)
                    }.subscribe()
    }

    override fun addTaskToDo(taskText: String, operation: () -> Unit) {
        Single.fromCallable {
            dataManager.addTaskToDoAndToday(null, taskText.trim())
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({operation()}, Throwable::printStackTrace)

    }

    override fun addTaskListId(taskText: String, listId: Long,  operation: () -> Unit) {
        Single.fromCallable {
            dataManager.addTaskList(listId, taskText.trim())
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({operation()}, Throwable::printStackTrace)
    }



}