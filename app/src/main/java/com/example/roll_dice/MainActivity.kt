package com.example.roll_dice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.roll_dice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding(layoutInflater)
        setContentView(binding.root)
        for (i in 1 until 20) {
            ContactList.addContact(Contact("$i", "name $i", "012345678", "email $i"))
        }

        val adapter = Adapter(ContactList.contacts){
            openDetail(it)
        }
        binding.rcv.adapter = adapter
    }

    private fun openDetail(contact: Contact) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("Contact", contact)
        startActivity(intent)
    }


    private fun getViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }
}