package com.example.hassanusman.getdisciplined.ui.main.task.list

import com.example.hassanusman.getdisciplined.data.db.model.ListId
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskMvpPresenter

/**
 * Created by HassanUsman on 03/11/2017.
 */
interface ListMvpPresenter<V : ListMvpView> : BaseTaskMvpPresenter<V> {
    fun getListIdTitle(id: Long)

    fun getTasksByListId(id: Long)

    fun deleteList(listId: ListId)
}