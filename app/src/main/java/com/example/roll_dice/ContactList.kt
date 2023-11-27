package com.example.roll_dice

object ContactList {
    val contacts = mutableListOf<Contact>()

    fun addContact(contact: Contact){
        if (contacts.contains(contact)){
            return;
        }
        contacts.add(contact)
    }
}