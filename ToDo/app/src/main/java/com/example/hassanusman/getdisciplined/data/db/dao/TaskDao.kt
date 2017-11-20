package com.example.hassanusman.getdisciplined.data.db.dao

import android.arch.persistence.room.*
import com.example.hassanusman.getdisciplined.data.db.model.Task
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by HassanUsman on 18/09/2017.
 */
@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAllTasks(): Flowable<List<Task>>

    @Query("SELECT * FROM task WHERE dateId = :date ORDER BY taskOrder")
    fun getTasksByDayId(date: Long): Single<List<Task>>

    @Query("SELECT * FROM task WHERE dateId = :date AND status = 0 ORDER BY taskOrder")
    fun getTasksByDayIdStatusFalse(date: Long): Single<List<Task>>

    @Query("SELECT * FROM task WHERE listId = :theId ORDER BY taskOrder")
    fun getTasksByListId(theId: Long): Single<List<Task>>

    @Query("SELECT * FROM task WHERE listId = :theId AND status = 0 ORDER BY taskOrder")
    fun getTasksByListIdStatusFalse(theId: Long): Single<List<Task>>

    @Query("SELECT * FROM task WHERE listId IS NULL ORDER BY taskOrder")
    fun getTasksToDo(): Single<List<Task>>

    @Query("SELECT * FROM task WHERE listId IS NULL AND status = 0 ORDER BY taskOrder")
    fun getTasksToDoStatusFalse(): Single<List<Task>>

    @Query("SELECT COUNT(task.id) FROM task WHERE listId = :theId")
    fun getTaskCountByListId(theId: Long): Int

    @Query("SELECT COUNT(task.id) FROM task WHERE listId IS NULL")
    fun getTaskCountToDoAndToday(): Int

    @Update
    fun updateTask(task: Task)

    @Delete
    fun delete(task: Task)

    @Insert
    fun insert(task: Task)
}


