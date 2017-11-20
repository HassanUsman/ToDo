package com.example.hassanusman.getdisciplined.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.example.hassanusman.getdisciplined.di.ActivityContext
import com.example.hassanusman.getdisciplined.di.PerActivity
import com.example.hassanusman.getdisciplined.ui.main.MainMvpPresenter
import com.example.hassanusman.getdisciplined.ui.main.MainMvpView
import com.example.hassanusman.getdisciplined.ui.main.MainPresenter
import com.example.hassanusman.getdisciplined.ui.main.navigationItem.ListIdNameDialogMvpPresenter
import com.example.hassanusman.getdisciplined.ui.main.navigationItem.ListIdNameDialogMvpView
import com.example.hassanusman.getdisciplined.ui.main.navigationItem.ListIdNameDialogPresenter
import com.example.hassanusman.getdisciplined.ui.main.task.today.TaskMvpPresenter
import com.example.hassanusman.getdisciplined.ui.main.task.today.TaskMvpView
import com.example.hassanusman.getdisciplined.ui.main.task.today.TaskPresenter
import com.example.hassanusman.getdisciplined.ui.main.task.add.AddMvpPresenter
import com.example.hassanusman.getdisciplined.ui.main.task.add.AddMvpView
import com.example.hassanusman.getdisciplined.ui.main.task.add.AddPresenter
import com.example.hassanusman.getdisciplined.ui.main.task.list.ListMvpPresenter
import com.example.hassanusman.getdisciplined.ui.main.task.list.ListMvpView
import com.example.hassanusman.getdisciplined.ui.main.task.list.ListPresenter
import com.example.hassanusman.getdisciplined.ui.main.task.todo.ToDoListMvpPresenter
import com.example.hassanusman.getdisciplined.ui.main.task.todo.ToDoListMvpView
import com.example.hassanusman.getdisciplined.ui.main.task.todo.ToDoListPresenter
import com.example.hassanusman.getdisciplined.ui.splash.SplashMvpPresenter
import com.example.hassanusman.getdisciplined.ui.splash.SplashMvpView
import com.example.hassanusman.getdisciplined.ui.splash.SplashPresenter
import com.example.hassanusman.getdisciplined.utils.rx.AppSchedulerProvider
import com.example.hassanusman.getdisciplined.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by HassanUsman on 10/09/2017.
 */
@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context = activity

    @Provides
    fun provideActivity(): AppCompatActivity = activity

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @PerActivity
    fun provideSplashPresenter(presenter: SplashPresenter<SplashMvpView>): SplashMvpPresenter<SplashMvpView> = presenter

    @Provides
    @PerActivity
    fun provideMainPresenter(presenter: MainPresenter<MainMvpView>): MainMvpPresenter<MainMvpView> = presenter

    @Provides
    fun provideListIdNameDialogPresenter(presenter: ListIdNameDialogPresenter<ListIdNameDialogMvpView>): ListIdNameDialogMvpPresenter<ListIdNameDialogMvpView> = presenter

    @Provides
    fun provideTaskMvpPresenter(presenter: TaskPresenter<TaskMvpView>): TaskMvpPresenter<TaskMvpView> = presenter

    @Provides
    fun provideSchedulerManager(): SchedulerProvider = AppSchedulerProvider()

    @Provides
    fun provideAddMvpPresenter(presenter: AddPresenter<AddMvpView>): AddMvpPresenter<AddMvpView> = presenter

    @Provides
    fun provideListMvpPresenter(presenter: ListPresenter<ListMvpView>) : ListMvpPresenter<ListMvpView> = presenter

    @Provides
    fun provideToDoListMvpPresenter(presenter: ToDoListPresenter<ToDoListMvpView>): ToDoListMvpPresenter<ToDoListMvpView> = presenter
}