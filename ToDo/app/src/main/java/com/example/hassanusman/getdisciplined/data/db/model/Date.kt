package com.example.hassanusman.getdisciplined.data.db.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by HassanUsman on 18/09/2017.
 */
@Entity
data class Date (
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        var date: Long
)
