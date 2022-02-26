package com.example.testapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact")
    fun getAll(): Observable<List<Contact>>

    @Query("SELECT * FROM contact WHERE id = :id")
    fun getById(id: Long): Single<Contact>

    @Insert
    fun insert(employee: Contact): Completable

    @Update
    fun update(employee: Contact): Completable

    @Delete
    fun delete(employee: Contact): Completable
}