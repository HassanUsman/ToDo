package com.example.hassanusman.getdisciplined.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.hassanusman.getdisciplined.data.db.dao.DateDao
import com.example.hassanusman.getdisciplined.data.db.dao.ListIdDao
import com.example.hassanusman.getdisciplined.data.db.dao.TaskDao
import com.example.hassanusman.getdisciplined.data.db.model.Date
import com.example.hassanusman.getdisciplined.data.db.model.ListId
import com.example.hassanusman.getdisciplined.data.db.model.Task

/**
 * Created by HassanUsman on 18/09/2017.
 */
@Database(entities = arrayOf(Date::class, Task::class, ListId::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dateDao(): DateDao
    abstract fun taskDao(): TaskDao
    abstract fun listIdDao(): ListIdDao
}