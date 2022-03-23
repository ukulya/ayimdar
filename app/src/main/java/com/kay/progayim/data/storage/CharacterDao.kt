package com.kay.progayim.data.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kay.progayim.data.models.CharacterEntity
import io.reactivex.Completable

@Dao
interface CharacterDao {

    @Query("SELECT * FROM CharacterEntity")
    fun getAll(): LiveData<List<CharacterEntity>>

    @Query("SELECT * FROM CharacterEntity WHERE id = :id")
    fun getById(id: Long?): CharacterEntity

    @Insert
    fun insert(character: CharacterEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(characters: List<CharacterEntity>)

    @Update
    fun update(character: CharacterEntity)

    @Delete
    fun delete(character: CharacterEntity)

    @Query("DELETE from CharacterEntity")
    fun deleteAll(): Completable
}