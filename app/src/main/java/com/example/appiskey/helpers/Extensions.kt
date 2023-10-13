package com.example.appiskey.helpers

import android.app.Activity
import android.content.Context
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.appiskey.R

object Extensions {

    fun Activity.changeColorStatusBar(color: Int) {
        val window: Window = window
        val decorView = window.decorView
        val wic = WindowInsetsControllerCompat(window, decorView)
        wic.isAppearanceLightStatusBars = true
        window.statusBarColor = ContextCompat.getColor(this, color)
    }

}