package com.example.hassanusman.getdisciplined.ui.base

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.AppCompatDrawableManager
import android.widget.ImageView
import android.widget.TextView
import java.util.*

/**
 * Created by HassanUsman on 10/09/2017.
 */
interface MvpView {
    fun hideKeyboard()

    fun showToast(message: String)

    fun ImageView.imageBackground(drawable: Int)

    fun transparentStatusBar()

    fun TextView.setFont(fontPath : String)
}