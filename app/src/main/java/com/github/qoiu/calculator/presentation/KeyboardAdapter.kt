package com.github.qoiu.calculator.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.qoiu.calculator.databinding.KeyboardItemBinding

class KeyboardAdapter(private var list: List<UiKey> = emptyList()) : RecyclerView.Adapter<KeyboardAdapter.KeyboardHolder>() {


    fun updateList(list: List<UiKey>){
        this.list = list
        notifyDataSetChanged()
    }

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

    inner class KeyboardHolder(private  val view: KeyboardItemBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: UiKey){
            view.text.text = item.value
            view.text.setOnClickListener { item.action() }
        }

    }
}