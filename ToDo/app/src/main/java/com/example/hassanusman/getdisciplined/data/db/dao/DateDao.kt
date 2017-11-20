package com.example.hassanusman.getdisciplined.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.hassanusman.getdisciplined.data.db.model.Date
import io.reactivex.Flowable
import io.reactivex.Maybe

/**
 * Created by HassanUsman on 18/09/2017.
 */
@Dao
interface DateDao {
    @Query("SELECT * FROM date")
    fun getAllDate(): Flowable<List<Date>>

    @Query("SELECT id, date FROM date WHERE date = :mDate LIMIT 1")
    fun getDateId(mDate: Long): List<Date>

    @Insert
    fun insert(date: Date)
}