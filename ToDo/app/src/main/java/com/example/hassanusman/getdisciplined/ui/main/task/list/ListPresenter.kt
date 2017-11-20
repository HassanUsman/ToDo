package com.example.hassanusman.getdisciplined.ui.main.task.list

import com.example.hassanusman.getdisciplined.data.DataManager
import com.example.hassanusman.getdisciplined.data.db.model.ListId
import com.example.hassanusman.getdisciplined.data.db.model.Task
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskPresenter
import com.example.hassanusman.getdisciplined.utils.rx.SchedulerProvider
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by HassanUsman on 03/11/2017.
 */
class ListPresenter<V: ListMvpView>
    @Inject constructor(dataManager: DataManager,
                        schedulerProvider: SchedulerProvider,
                        compositeDisposable: CompositeDisposable) :
    BaseTaskPresenter<V>(dataManager, schedulerProvider, compositeDisposable), ListMvpPresenter<V> {

    private val TAG = "ListPresenter"

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        mvpView.setFragment(this)
    }

    override fun getTasksByListId(id: Long) {
        dataManager.getTasksByListId(id, dataManager.getFinishedTasksVisibility())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    mvpView?.updateTasksList(it as ArrayList<Task>)
                }, Throwable::printStackTrace)
    }

    override fun getListIdTitle(id: Long) {
        dataManager.getListIdName(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    mvpView?.setToolbar(it)
                }, Throwable::printStackTrace)
    }

    override fun deleteList(listId: ListId) {
        Single.fromCallable {
            dataManager.deleteListId(listId)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    mvpView?.deleteList()
                }, Throwable::printStackTrace)
    }




}