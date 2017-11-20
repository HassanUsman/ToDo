package com.example.hassanusman.getdisciplined.data

import android.content.Context
import android.util.Log
import com.example.hassanusman.getdisciplined.R
import com.example.hassanusman.getdisciplined.data.db.AppDatabase
import com.example.hassanusman.getdisciplined.data.db.model.Date
import com.example.hassanusman.getdisciplined.data.db.model.ListId
import com.example.hassanusman.getdisciplined.data.db.model.Task
import com.example.hassanusman.getdisciplined.data.prefs.AppPreferencesHelper
import com.example.hassanusman.getdisciplined.data.prefs.PreferencesHelper
import com.example.hassanusman.getdisciplined.di.ApplicationContext
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by HassanUsman on 11/09/2017.
 */
@Singleton
class AppDataManager @Inject constructor(@ApplicationContext val context: Context,
                                         private val database: AppDatabase,
                                         private val preferencesHelper: PreferencesHelper) : DataManager {


    // Date

    override fun addDate(date: Long) {
        val _date = Date(0, date)

        Observable.fromCallable {
            database.dateDao().insert(_date)
        }.subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    override fun getDateId(date: Long):  List<Date> =
            database.dateDao().getDateId(date)

    // List


    override fun addListId() {
        val count = database.listIdDao().getListsCount()

        val name = context.resources.getString(R.string.untitled_list)

        Single.fromCallable {
            database.listIdDao().insert(ListId(0, name, count))
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    override fun getLastId() : Single<ListId> =
            database.listIdDao().getLastListId()

    override fun getAllListId(): Flowable<List<ListId>> =
            database.listIdDao().getAll()

    override fun updateListId(listId: ListId) {
        Single.fromCallable {
            database.listIdDao().updateListId(listId)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    override fun deleteListId(listId: ListId) {
        Single.fromCallable {
            database.listIdDao().deleteListId(listId)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    override fun getListIdName(id: Long): Single<String> =
            database.listIdDao().getListIdName(id)


    // Tasks

    override fun getAllTasks(): Flowable<List<Task>> =
        database.taskDao().getAllTasks()


    override fun addTaskList(listId: Long, task: String) {
        val count = database.taskDao().getTaskCountByListId(listId)
        val _task = Task(0, null, listId, task, count)
        database.taskDao().insert(_task)
    }

    override fun addTaskToDoAndToday(dateId: Long?, task: String) {
        val count = database.taskDao().getTaskCountToDoAndToday()
        val _task = Task(0, dateId, null, task, count)
        database.taskDao().insert(_task)
    }

    override fun getTasksByDayId(date: Long, status: Boolean): Single<List<Task>> = when(status) {
        true -> database.taskDao().getTasksByDayId(date)
        false -> database.taskDao().getTasksByDayIdStatusFalse(date)
    }

    override fun getTasksToDo(status: Boolean): Single<List<Task>> = when(status) {
        true ->  database.taskDao().getTasksToDo()
        false -> database.taskDao().getTasksToDoStatusFalse()
    }

    override fun getTasksByListId(id: Long, status: Boolean): Single<List<Task>> = when(status) {
        true -> database.taskDao().getTasksByListId(id)
        false -> database.taskDao().getTasksByListIdStatusFalse(id)
    }

    override fun updateTaskOrder(task: Task, order: Int) {
        task.taskOrder = order

        Single.fromCallable {
            database.taskDao().updateTask(task)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    override fun updateTaskStatus(task: Task) {
        Single.fromCallable {
            database.taskDao().updateTask(task)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    override fun deleteTask(task: Task) {
        Single.fromCallable {
            database.taskDao().delete(task)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }





    // Preferences

    override fun setFinishedTasksVisibility(status: Boolean) {
        preferencesHelper.setFinishedTasksVisibility(status)
    }

    override fun getFinishedTasksVisibility(): Boolean =
            preferencesHelper.getFinishedTasksVisibility()



}