package com.example.testapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
// skeleton
@Entity
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String,
    val company: String,
    val salary: String
)