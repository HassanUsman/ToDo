package com.example.hassanusman.getdisciplined.ui.main.task.add

import android.os.Bundle
import android.util.Log
import android.view.*
import com.example.hassanusman.getdisciplined.R
import com.example.hassanusman.getdisciplined.ui.base.BaseFragment
import com.example.hassanusman.getdisciplined.ui.main.task.base.BaseTaskFragment
import com.example.hassanusman.getdisciplined.ui.main.task.list.ListFragment
import com.example.hassanusman.getdisciplined.ui.main.task.today.TaskFragment
import com.example.hassanusman.getdisciplined.ui.main.task.todo.ToDoListFragment
import com.example.hassanusman.getdisciplined.utils.KeyboardUtils
import kotlinx.android.synthetic.main.task_add_item.*
import javax.inject.Inject

/**
 * Created by HassanUsman on 05/10/2017.
 */
class AddFragment : BaseFragment(), AddMvpView {
    private val TAG = "AddFragment"

    @Inject lateinit var presenter: AddMvpPresenter<AddMvpView>

    private val itemInserted = {(parentFragment as BaseTaskFragment).updateTasksArray()}

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity.activityComponent.inject(this)

        presenter.onAttach(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.task_add_item, container, false)

    override fun setFragment() {
        addButton.setOnClickListener {
            addTaskAction()
        }

        KeyboardUtils.showSoftInput(textTask, context)

        textTask.setOnEditorActionListener { textView, i, keyEvent ->
            Log.d(TAG, "$i - $keyEvent")
            if(i == KeyEvent.KEYCODE_ENDCALL) {
                addTaskAction()
            }
            true
        }
    }

    override fun clearEditText() {
        textTask.text.clear()
    }

    override fun addTaskAction() {
        val text = textTask.text.toString()

        if(text.isNotEmpty()) {
            when (parentFragment::class) {
                ListFragment::class -> {
                    presenter.addTaskListId(text, currentListId!!.id, itemInserted)
                }
                ToDoListFragment::class -> {
                    presenter.addTaskToDo(text, itemInserted)
                }
                TaskFragment::class -> {
                    presenter.addTaskToday(text, itemInserted)
                }

            }
        } else {
            showToast("text is empty")
        }

        clearEditText()
    }






}