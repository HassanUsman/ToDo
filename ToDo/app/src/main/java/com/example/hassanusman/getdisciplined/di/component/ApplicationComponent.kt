package com.example.hassanusman.getdisciplined.di.component

import android.app.Application
import android.content.Context
import com.example.hassanusman.getdisciplined.App
import com.example.hassanusman.getdisciplined.data.DataManager
import com.example.hassanusman.getdisciplined.data.db.AppDatabase
import com.example.hassanusman.getdisciplined.di.ApplicationContext
import com.example.hassanusman.getdisciplined.di.module.ApplicationModule
import com.example.hassanusman.getdisciplined.ui.main.ListAdapter
import com.example.hassanusman.getdisciplined.ui.main.task.base.TaskAdapter
import com.example.hassanusman.getdisciplined.utils.itemtouch.DragableAdapter
import com.example.hassanusman.getdisciplined.utils.rx.SchedulerProvider
import dagger.Component
import javax.inject.Singleton

/**
 * Created by HassanUsman on 10/09/2017.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(app: App)
    fun inject(taskAdapter: TaskAdapter)
    fun inject(listAdapter: ListAdapter)

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun getDataManager(): DataManager

    fun getAppDatabase(): AppDatabase

}