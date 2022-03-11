package com.github.qoiu.calculator.presentation.keyboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.github.qoiu.calculator.databinding.FragmentKeyboardBinding
import com.github.qoiu.calculator.presentation.BaseFragment

class KeyboardFragment : BaseFragment<KeyboardViewModel, FragmentKeyboardBinding>() {

    override fun viewModelClass(): Class<KeyboardViewModel> = KeyboardViewModel::class.java
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentKeyboardBinding.inflate(inflater, container, false)

    override fun init(binding: FragmentKeyboardBinding) {
        val recycler = binding.keyboardRecycler
        val keyboard = KeyboardData(viewModel)
        recycler.layoutManager = GridLayoutManager(context, keyboard.defaultKeyboard.gridSize)
        recycler.adapter = KeyboardAdapter(keyboard.defaultKeyboard.keys)
    }
}