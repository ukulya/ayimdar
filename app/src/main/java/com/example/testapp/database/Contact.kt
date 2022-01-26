package com.example.testapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
// skeleton
@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String,
    val phone: String,
)