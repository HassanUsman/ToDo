package com.example.hassanusman.getdisciplined.di.component

import com.example.hassanusman.getdisciplined.di.PerActivity
import com.example.hassanusman.getdisciplined.di.module.ActivityModule
import com.example.hassanusman.getdisciplined.ui.main.MainActivity
import com.example.hassanusman.getdisciplined.ui.main.navigationItem.ListIdNameDialog
import com.example.hassanusman.getdisciplined.ui.main.task.today.TaskFragment
import com.example.hassanusman.getdisciplined.ui.main.task.add.AddFragment
import com.example.hassanusman.getdisciplined.ui.main.task.list.ListFragment
import com.example.hassanusman.getdisciplined.ui.main.task.todo.ToDoListFragment
import com.example.hassanusman.getdisciplined.ui.splash.SplashActivity
import dagger.Component

/**
 * Created by HassanUsman on 10/09/2017.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(splashActivity: SplashActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(taskFragment: TaskFragment)
    fun inject(addFragment: AddFragment)
    fun inject(toDoListFragment: ToDoListFragment)
    fun inject(listFragment: ListFragment)
    fun inject(listIdNameDialog: ListIdNameDialog)
}