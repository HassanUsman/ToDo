package com.example.hassanusman.getdisciplined.ui.main.navigationItem

import com.example.hassanusman.getdisciplined.data.db.model.ListId
import com.example.hassanusman.getdisciplined.ui.base.MvpPresenter

/**
 * Created by HassanUsman on 05/11/2017.
 */
interface ListIdNameDialogMvpPresenter<V : ListIdNameDialogMvpView> : MvpPresenter<V> {
    fun updateListId(listId: ListId)

    fun cancelListId(listId: ListId)
}