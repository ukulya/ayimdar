package com.kay.progayim.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val char_id: Long,
    val name: String,
    val birthday: String,
    val img: String,
    val status: String,
    val nickname: String,
    val portrayed: String,
    val category: String,
)