package com.github.qoiu.calculator.presentation.output

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.github.qoiu.calculator.databinding.FragmentOutputBinding
import com.github.qoiu.calculator.domain.model.OutputResult
import com.github.qoiu.calculator.presentation.BaseFragment

class OutputFragment : BaseFragment<OutputViewModel, FragmentOutputBinding>() {
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentOutputBinding.inflate(inflater, container, false)

    override fun viewModelClass() = OutputViewModel::class.java

    override fun init(binding: FragmentOutputBinding) {
        viewModel.subscribe(this) {
            Log.w("Output", it.toString())
            when (it) {
                is OutputResult.Success -> {
                    binding.text.text = it.arguments
                    binding.result.text = it.result
                }
                is OutputResult.Error -> Toast.makeText(
                    context,
                    it.e.message ?: "error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}