package com.example.roll_dice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roll_dice.databinding.ActivityDetailBinding
import com.example.roll_dice.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private var contact: Contact? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent?.let {
            parseArgs(it)
        }

        contact?.let {
            binding.img.text = contact!!.name[0].uppercase()
            binding.name.text = contact!!.name
            binding.phoneNumber.text = contact!!.phoneNumber
            binding.email.text = contact!!.email
        }
    }

    private fun parseArgs(it: Intent) {
        try {
            contact = it.getSerializableExtra("Contact") as Contact?;
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }
}