package com.example.hassanusman.getdisciplined

import android.app.Application
import android.arch.persistence.room.Room
import com.example.hassanusman.getdisciplined.data.DataManager
import com.example.hassanusman.getdisciplined.data.db.AppDatabase
import com.example.hassanusman.getdisciplined.di.component.ApplicationComponent
import com.example.hassanusman.getdisciplined.di.component.DaggerApplicationComponent
import com.example.hassanusman.getdisciplined.di.module.ApplicationModule
import javax.inject.Inject

/**
 * Created by HassanUsman on 10/09/2017.
 */
class App : Application() {

    @Inject lateinit var dataManager: DataManager

     private val applicationComponent: ApplicationComponent by lazy {
         DaggerApplicationComponent
                 .builder()
                 .applicationModule(ApplicationModule(this))
                 .build()
     }

    override fun onCreate() {
        super.onCreate()

        applicationComponent.inject(this)
    }

    fun component() = applicationComponent
}