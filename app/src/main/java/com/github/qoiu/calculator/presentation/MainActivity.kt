package com.github.qoiu.calculator.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.qoiu.calculator.R
import com.github.qoiu.calculator.presentation.keyboard.KeyboardFragment
import com.github.qoiu.calculator.presentation.output.OutputFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container_bottom, KeyboardFragment())
            .commit()
        supportFragmentManager.beginTransaction().add(R.id.container_top, OutputFragment()).commit()
    }
}