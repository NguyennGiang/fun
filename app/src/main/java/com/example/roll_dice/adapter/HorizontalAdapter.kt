package com.example.roll_dice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roll_dice.databinding.ListItemHorizontalBinding
import com.example.roll_dice.model.ItemHorizontal

class HorizontalAdapter(private val items: List<ItemHorizontal>): RecyclerView.Adapter<HorizontalAdapter.Holder>(){
    inner class Holder(private val binding: ListItemHorizontalBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            val item = items[position]
            binding.name.text = item.name
            binding.rating.text = item.rating

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ListItemHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }
}