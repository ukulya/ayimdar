package com.example.testapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM contact WHERE id = :id")
    fun getById(id: Long): Contact

    @Insert
    fun insert(employee: Contact)

    @Update
    fun update(employee: Contact)

    @Delete
    fun delete(employee: Contact)
}