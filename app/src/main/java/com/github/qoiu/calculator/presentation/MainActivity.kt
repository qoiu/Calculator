package com.github.qoiu.calculator.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.qoiu.calculator.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container_bottom,KeyboardFragment()).commit()
    }
}