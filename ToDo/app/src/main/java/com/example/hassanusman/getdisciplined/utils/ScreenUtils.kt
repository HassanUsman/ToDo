package com.example.hassanusman.getdisciplined.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Created by HassanUsman on 10/09/2017.
 */
class ScreenUtils {
    companion object {
        fun getScreenWidth(context: Context): Int {
            val windowManager = context
                    .getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(dm)
            return dm.widthPixels
        }

        fun getScreenHeight(context: Context): Int {
            val windowManager = context
                    .getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(dm)
            return dm.heightPixels
        }

        fun getStatusBarHeight(context: Context): Int {
            var result = 0
            val resourceId = context.resources
                    .getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = context.resources.getDimensionPixelSize(resourceId)
            }
            return result
        }
    }
}