package com.example.hassanusman.getdisciplined.data.prefs

/**
 * Created by HassanUsman on 09/11/2017.
 */
interface PreferencesHelper {
    fun setFinishedTasksVisibility(status: Boolean)

    fun getFinishedTasksVisibility(): Boolean
}