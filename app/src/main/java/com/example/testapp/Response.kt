package com.example.testapp

import java.util.*
data class Response(
    val results: List<Character>
)
data class Character(
    val id: Long?,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
)

data class Location(
    val name: String,
    val url: String,
)
