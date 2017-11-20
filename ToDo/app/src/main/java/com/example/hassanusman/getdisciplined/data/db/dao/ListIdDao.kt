package com.example.hassanusman.getdisciplined.data.db.dao

import android.arch.persistence.room.*
import com.example.hassanusman.getdisciplined.data.db.model.ListId
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by HassanUsman on 03/11/2017.
 */
@Dao
interface ListIdDao {
    @Query("SELECT * FROM listId ORDER BY listOrder")
    fun getAll(): Flowable<List<ListId>>

    @Query("SELECT * FROM listId ORDER BY id DESC LIMIT 1")
    fun getLastListId(): Single<ListId>

    @Query("SELECT name FROM listId WHERE id = :mId LIMIT 1")
    fun getListIdName(mId: Long): Single<String>

    @Query("SELECT COUNT(listId.id) FROM listId")
    fun getListsCount(): Long

    @Insert
    fun insert(list: ListId)

    @Update
    fun updateListId(listId: ListId)

    @Delete
    fun deleteListId(listId: ListId)

}