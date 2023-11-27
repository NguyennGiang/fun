package com.example.roll_dice

import java.io.Serializable

data class Contact(
    val id: String,
    val name: String,
    val phoneNumber: String,
    val email: String,
): Serializable
