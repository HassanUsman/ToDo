package com.example.hassanusman.getdisciplined.ui.main.task.todo

import android.os.Bundle
import android.view.*
import com.example.hassanusman.getdisciplined.R
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskFragment
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskMvpView
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskPresenter
import kotlinx.android.synthetic.main.fragment_tasks.*
import javax.inject.Inject

/**
 * Created by HassanUsman on 11/10/2017.
 */
class ToDoListFragment : BaseTaskFragment(), ToDoListMvpView {
    private val TAG = "ToDListFragment"

    @Inject lateinit var presenter: ToDoListMvpPresenter<ToDoListMvpView>

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMenu()

        activity.activityComponent.inject(this)
        presenter.onAttach(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_tasks, container, false)

    private fun setMenu() {
        toolbar.inflateMenu(R.menu.main)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.check -> {
                    presenter.changeTaskVisibility()
                }
            }
            false
        }
    }

    override fun <V : BaseTaskMvpView> setFragment(presenter: BaseTaskPresenter<V>) {
        setToolbar(resources.getString(R.string.todo))
        presenter.isTodayExist()
        super.setFragment(presenter)


    }

    override fun updateTasksArray() {
        presenter.isTodayExist()
    }


}