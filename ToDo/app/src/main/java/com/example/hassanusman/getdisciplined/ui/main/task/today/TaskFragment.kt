package com.example.hassanusman.getdisciplined.ui.main.task.today

import android.os.Bundle
import android.util.Log
import android.view.*
import com.example.hassanusman.getdisciplined.R
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskFragment
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskMvpView
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskPresenter
import kotlinx.android.synthetic.main.fragment_tasks.*
import javax.inject.Inject

/**
 * Created by HassanUsman on 19/09/2017.
 */
class TaskFragment : BaseTaskFragment(), TaskMvpView {
    private val TAG = "TaskFragment"

    @Inject lateinit var presenter: TaskMvpPresenter<TaskMvpView>

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMenu()

        activity.activityComponent.inject(this)
        presenter.onAttach(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?  =
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
        setToolbar(resources.getString(R.string.myday))
        presenter.isTodayExist()
        super.setFragment(presenter)


    }

    override fun updateTasksArray() {
        Log.d(TAG, "UPDATE ARRAY")
        presenter.isTodayExist()
    }
}