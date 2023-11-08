package com.example.roll_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.roll_dice.adapter.VerticalAdapter
import com.example.roll_dice.databinding.ActivityMainBinding
import com.example.roll_dice.model.ItemHorizontal
import com.example.roll_dice.model.ItemVertical

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding(layoutInflater)
        setContentView(binding.root)
        var items = mutableListOf<ItemVertical>()
        for (i in 1..30){
            var itemHorizontals = mutableListOf<ItemHorizontal>()
            for(i in 1..20){
                itemHorizontals.add(
                    ItemHorizontal(
                        "Game $i",
                        "4.5"
                    )
                )
            }
            items.add(
                ItemVertical(
                "Popular App $i",
                    itemHorizontals
                )
            )
        }

        val adapter = VerticalAdapter(items)
        binding.rcvVertical.adapter = adapter
    }


    private fun getViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }
}