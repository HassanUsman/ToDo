package com.example.hassanusman.getdisciplined.ui.main.task.list


import android.os.Bundle
import android.view.*
import com.example.hassanusman.getdisciplined.R
import com.example.hassanusman.getdisciplined.ui.main.MainActivity
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskFragment
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskMvpView
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskPresenter
import kotlinx.android.synthetic.main.fragment_tasks.*
import javax.inject.Inject

/**
 * Created by HassanUsman on 03/11/2017.
 */
class ListFragment : BaseTaskFragment(), ListMvpView {

    private val TAG = "ListFragment"

    private lateinit var mainActivity: MainActivity

    @Inject lateinit var presenter: ListMvpPresenter<ListMvpView>

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMenu()

        activity.activityComponent.inject(this)
        presenter.onAttach(this)

        mainActivity = (activity as MainActivity)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_tasks, container, false)


    override fun setToolbar(text: String) {
        toolbar.title = text
    }

    override fun updateTasksArray() {
        presenter.getTasksByListId(currentListId!!.id)
    }

    override fun <V : BaseTaskMvpView> setFragment(presenter: BaseTaskPresenter<V>) {
        super.setFragment(presenter)

        this.presenter.getListIdTitle(currentListId!!.id)
        this.presenter.getTasksByListId(currentListId!!.id)
    }

    private fun setMenu() {
        toolbar.inflateMenu(R.menu.list)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.deleteListId -> {
                    presenter.deleteList(mainActivity.currentListId!!)
                }
                R.id.check -> {
                    presenter.changeTaskVisibility()
                }
            }
            false
        }
    }

    override fun deleteList() {
        mainActivity.clickedTodayOrToDoItem(0)
    }
}