package com.github.qoiu.calculator.presentation.output

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.qoiu.calculator.domain.UseCaseObserveOutput
import com.github.qoiu.calculator.domain.model.OutputResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OutputViewModel(
    private val observe: UseCaseObserveOutput,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    private val liveData: MutableLiveData<OutputResult> = MutableLiveData()

    fun subscribe(owner: LifecycleOwner, observer: androidx.lifecycle.Observer<OutputResult>) {
        liveData.observe(owner, observer)
        viewModelScope.launch(dispatcher) {
            observe.subscribe { result ->
                liveData.value = result
            }
        }
    }
}