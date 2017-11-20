package com.example.hassanusman.getdisciplined.ui.main.task.today

import android.util.Log
import com.example.hassanusman.getdisciplined.data.DataManager
import com.example.hassanusman.getdisciplined.data.db.model.Task
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskPresenter
import com.example.hassanusman.getdisciplined.utils.rx.SchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by HassanUsman on 19/09/2017.
 */
class TaskPresenter<V : TaskMvpView> @Inject constructor(dataManager: DataManager,
                                                         schedulerProvider: SchedulerProvider,
                                                         compositeDisposable: CompositeDisposable) :
        BaseTaskPresenter<V>(dataManager, schedulerProvider, compositeDisposable), TaskMvpPresenter<V> {

    private val TAG = "TaskPresenter"

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        mvpView.setFragment(this)
    }

    override fun getTasks(dateId: Long) {
        Log.d(TAG, "TODAY GET TASKS")
        dataManager.getTasksByDayId(dateId, dataManager.getFinishedTasksVisibility())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    Log.d(TAG, "TASKS : $it / status : ${dataManager.getFinishedTasksVisibility()}")
                    mvpView?.updateTasksList(it as ArrayList<Task>)
                }, Throwable::printStackTrace)
    }












}