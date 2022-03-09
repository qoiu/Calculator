package com.github.qoiu.calculator.presentation.output

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
            when (it) {
                is OutputResult.Success -> if (it.result.isNotEmpty()) binding.text.text =
                    it.result[0].toString()
                is OutputResult.Error -> Toast.makeText(
                    context,
                    it.e.message ?: "error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}