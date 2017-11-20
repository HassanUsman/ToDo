package com.example.hassanusman.getdisciplined.ui.splash

import android.os.Bundle
import android.view.View
import com.example.hassanusman.getdisciplined.R
import com.example.hassanusman.getdisciplined.ui.base.BaseActivity
import com.example.hassanusman.getdisciplined.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashMvpView {
    @Inject lateinit var presenter : SplashMvpPresenter<SplashMvpView>

    override fun openMainActivity() {
        val intent = MainActivity.getStartIntent(this)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        activityComponent.inject(this)

        background.imageBackground(R.drawable.splash_background)

        transparentStatusBar()

        splashTitle.setFont("fonts/parisien_night.otf")

        presenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun setUp() {

    }


}
