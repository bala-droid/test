package com.baladroid.baseapp.view.base.fragments

import android.view.View
import android.view.Window
import android.view.WindowManager.LayoutParams.FLAG_SECURE
import com.baladroid.baseapp.BuildConfig

object ViewSecurity {

    fun avoidTapJacking(view: View) {
        if (!BuildConfig.DEBUG && BuildConfig.BUILD_TYPE != "integration") {
            view.filterTouchesWhenObscured = true
        }
    }

    fun blockScreenshots(window: Window) {
        if (!BuildConfig.DEBUG && BuildConfig.BUILD_TYPE != "integration") {
            window.setFlags(
                FLAG_SECURE,
                FLAG_SECURE
            )
        }
    }
}
