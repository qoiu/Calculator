package com.github.qoiu.calculator

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

class CalcApp: Application() {

    private val core = Core()
    override fun onCreate() {
        super.onCreate()
        core.init()
    }

    private val factory by lazy {
        ViewModelsFactory(core)
    }


    fun <T : ViewModel> viewModel(modelClass: Class<T>, owner: ViewModelStoreOwner): T =
        ViewModelProvider(owner, factory).get(modelClass)
}