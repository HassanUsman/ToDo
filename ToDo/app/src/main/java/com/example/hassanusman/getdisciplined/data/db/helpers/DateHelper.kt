package com.example.hassanusman.getdisciplined.data.db.helpers

import com.example.hassanusman.getdisciplined.data.db.model.Date
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * Created by HassanUsman on 10/11/2017.
 */
interface DateHelper {
    fun addDate(date: Long)

    fun getDateId(date: Long): List<Date>
}