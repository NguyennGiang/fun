package com.example.roll_dice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roll_dice.databinding.ListItemEmailBinding

class Adapter(private val items: List<ItemEmail>): RecyclerView.Adapter<Adapter.Holder>() {
    inner class Holder(private val binding: ListItemEmailBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            val item = items[position]
            binding.name.text = item.name
            binding.time.text = item.time
            binding.content.text = item.content
            if (position == items.size - 1){
                binding.line.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ListItemEmailBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }
}