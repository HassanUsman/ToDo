package com.example.hassanusman.getdisciplined.ui.main.navigationItem

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hassanusman.getdisciplined.R
import com.example.hassanusman.getdisciplined.ui.base.BaseDialog
import com.example.hassanusman.getdisciplined.ui.main.MainActivity
import com.example.hassanusman.getdisciplined.ui.main.task.list.ListFragment
import kotlinx.android.synthetic.main.dialog_listid_name.*
import javax.inject.Inject

/**
 * Created by HassanUsman on 05/11/2017.
 */
class ListIdNameDialog : BaseDialog(), ListIdNameDialogMvpView {
    val TAG = "ListIdNameDialog"

    @Inject lateinit var presenter: ListIdNameDialogMvpPresenter<ListIdNameDialogMvpView>

    private lateinit var mainActivity: MainActivity

    companion object {
        fun newInstance(): ListIdNameDialog {
            val fragment = ListIdNameDialog()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val component = getActivityComponent()

        component.inject(this)

        presenter.onAttach(this)

        mainActivity = (activity as MainActivity)

        positive.setOnClickListener {

            listId()?.name = listIdName.text.toString().trim()
            presenter.updateListId(listId()!!)
        }

        negative.setOnClickListener {
            presenter.cancelListId(listId()!!)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.dialog_listid_name, container, false)

    fun show(fragmentManager: FragmentManager) {
        super.show(fragmentManager, TAG)
    }

    override fun updateIdListTitleToolbar() {
        mainActivity.clickedNavigationItem(activity.currentListId!!)
    }

    override fun cancelCreatingListId() {
        mainActivity.clickedTodayOrToDoItem(0)
        mainActivity.openDrawer()
    }
}