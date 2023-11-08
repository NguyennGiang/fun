package com.example.roll_dice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roll_dice.databinding.ListItemVerticalBinding
import com.example.roll_dice.model.ItemVertical

class VerticalAdapter(private val items: List<ItemVertical>): RecyclerView.Adapter<VerticalAdapter.Holder>() {
    inner class Holder(private val binding: ListItemVerticalBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            val item = items[position]
            binding.header.text = item.header
            val adapter = HorizontalAdapter(item.items)
            binding.rcvHorizontal.adapter = adapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ListItemVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }
}