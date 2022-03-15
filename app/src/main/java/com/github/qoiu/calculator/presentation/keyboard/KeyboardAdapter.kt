package com.github.qoiu.calculator.presentation.keyboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.qoiu.calculator.databinding.KeyboardItemBinding
import com.github.qoiu.calculator.presentation.UiKey

class KeyboardAdapter(private val list: List<UiKey> = emptyList()) :
    RecyclerView.Adapter<KeyboardAdapter.KeyboardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = KeyboardHolder(
        KeyboardItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: KeyboardHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class KeyboardHolder(private val view: KeyboardItemBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(item: UiKey) {
            view.text.text = item.getText()
            view.text.setOnClickListener {
                item.action()
                if (item is UiKey.Switcher) view.text.text = item.getText()
            }
        }
    }
}