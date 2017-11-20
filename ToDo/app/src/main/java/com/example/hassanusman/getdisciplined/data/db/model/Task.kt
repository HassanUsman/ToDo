package com.example.hassanusman.getdisciplined.data.db.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

/**
 * Created by HassanUsman on 18/09/2017.
 */
@Entity(foreignKeys = arrayOf(ForeignKey(entity = Date::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("dateId"),
        onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = ListId::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("listId"),
                onDelete = ForeignKey.CASCADE)))
data class Task  (
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val dateId: Long?,
        var listId: Long?,
        var task: String,
        var taskOrder: Int,
        var status: Boolean = false
)