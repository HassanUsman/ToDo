package com.example.hassanusman.getdisciplined.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.example.hassanusman.getdisciplined.App
import com.example.hassanusman.getdisciplined.data.AppDataManager
import com.example.hassanusman.getdisciplined.data.DataManager
import com.example.hassanusman.getdisciplined.data.db.AppDatabase
import com.example.hassanusman.getdisciplined.data.prefs.AppPreferencesHelper
import com.example.hassanusman.getdisciplined.data.prefs.PreferencesHelper
import com.example.hassanusman.getdisciplined.di.ApplicationContext
import com.example.hassanusman.getdisciplined.di.PreferenceInfo
import com.example.hassanusman.getdisciplined.utils.AppConstants
import com.example.hassanusman.getdisciplined.utils.rx.AppSchedulerProvider
import com.example.hassanusman.getdisciplined.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by HassanUsman on 10/09/2017.
 */
@Module
class ApplicationModule(private val application: Application) {
    @Provides
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager = appDataManager

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper = appPreferencesHelper

    @Provides
    fun provideAppDatabase(): AppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "we-need-db").build()

}