package com.example.hassanusman.getdisciplined.ui.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.AppCompatDrawableManager
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.hassanusman.getdisciplined.data.db.model.ListId
import com.example.hassanusman.getdisciplined.di.component.ActivityComponent
import com.example.hassanusman.getdisciplined.utils.KeyboardUtils
import org.jetbrains.anko.support.v4.act
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast

/**
 * Created by HassanUsman on 05/11/2017.
 */
abstract class BaseDialog : DialogFragment(), DialogMvpView {

    lateinit var activity: BaseActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is BaseActivity) {
            activity = context
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // the content
        val root = RelativeLayout(getActivity())
        root.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

        // creating the fullscreen dialog
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(root)
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        dialog.setCanceledOnTouchOutside(false)

        return dialog
    }

    override fun dismissDialog() {
        dismiss()
    }

    override fun showToast(message: String) {
        toast(message)
    }

    override fun hideKeyboard() {
        KeyboardUtils.hideSoftInput(activity)
    }

    override fun ImageView.imageBackground(drawable: Int) {
        setImageDrawable(AppCompatDrawableManager.get().getDrawable(context, drawable))
    }

    override fun transparentStatusBar() {

    }

    override fun TextView.setFont(fontPath: String) {
        typeface = Typeface.createFromAsset(context.assets, fontPath)
    }

    fun getActivityComponent(): ActivityComponent = activity.activityComponent

    fun listId(): ListId? = activity.currentListId


    override fun show(fragmentManager: FragmentManager, tag: String) {
        val transaction: android.support.v4.app.FragmentTransaction = fragmentManager.beginTransaction()
        val prevFragment: android.support.v4.app.Fragment? = fragmentManager.findFragmentByTag(tag)
        if (prevFragment != null) {
            transaction.remove(prevFragment)
        }
        transaction.addToBackStack(null)
        show(transaction, tag)
    }
}