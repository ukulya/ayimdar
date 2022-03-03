package com.example.testapp

import java.util.*

data class Item(
    val id: Long?,
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?,
    val origin: List<String>?,
    val location: List<String>?,
    val image: String?,
    val url: String?,
    val created: Date?,
)
