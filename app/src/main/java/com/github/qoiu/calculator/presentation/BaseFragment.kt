package com.github.qoiu.calculator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.github.qoiu.calculator.CalcApp

abstract class BaseFragment<T: ViewModel,Binding : ViewBinding> : Fragment() {

    protected lateinit var viewModel: T
    private var _binding: Binding? = null
    private val binding get() = _binding!!
    protected abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): Binding
    open fun update() {}
    abstract fun init(binding: Binding)
    protected abstract fun viewModelClass(): Class<T>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (requireActivity().application as CalcApp).viewModel(viewModelClass(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(binding)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = initBinding(inflater, container)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}