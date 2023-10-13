package com.example.appiskey

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.appiskey.databinding.ActivityMainBinding
import com.example.appiskey.helpers.Extensions.changeColorStatusBar


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeColorStatusBar(R.color.white)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}