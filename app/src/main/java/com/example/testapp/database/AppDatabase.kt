package com.example.testapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

}