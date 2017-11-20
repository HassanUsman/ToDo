package com.example.hassanusman.getdisciplined.ui.base

import android.app.Service
import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatDrawableManager
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import com.example.hassanusman.getdisciplined.R
import com.example.hassanusman.getdisciplined.data.db.model.ListId
import com.example.hassanusman.getdisciplined.di.component.ActivityComponent
import com.example.hassanusman.getdisciplined.di.component.DaggerActivityComponent
import com.example.hassanusman.getdisciplined.di.module.ActivityModule
import com.example.hassanusman.getdisciplined.utils.KeyboardUtils
import com.example.hassanusman.getdisciplined.utils.app
import com.readystatesoftware.systembartint.SystemBarTintManager
import org.jetbrains.anko.toast
import java.util.*

/**
 * Created by HassanUsman on 10/09/2017.
 */
abstract class BaseActivity : AppCompatActivity(), MvpView {

    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent(app.component())
                .build()
    }


    var currentListId: ListId? = null
    val backgroundToolbar = getToolbarBackground()


    override fun showToast(message: String) {
        toast(message)
    }

    override fun hideKeyboard() {
        KeyboardUtils.hideSoftInput(this)
    }

    override fun ImageView.imageBackground(drawable: Int) {
        setImageDrawable(AppCompatDrawableManager.get().getDrawable(context, drawable))
    }

    override fun transparentStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = Color.TRANSPARENT

        val tintManager = SystemBarTintManager(this)
        // enable status bar tint
        tintManager.isStatusBarTintEnabled = true
        // enable navigation bar tint
        tintManager.setNavigationBarTintEnabled(true)
    }

    override fun TextView.setFont(fontPath: String) {
        typeface = Typeface.createFromAsset(context.assets, fontPath)
    }

    protected abstract fun setUp()

    fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    private fun getToolbarBackground(): Int {
        val images = arrayOf(R.drawable.splash_background, R.drawable.background2, R.drawable.background3, R.drawable.background4, R.drawable.background5, R.drawable.background6, R.drawable.background7, R.drawable.background8, R.drawable.background9)

        return images[Random().nextInt(images.size)]
    }


}