package com.anarkio.hema.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BloodPressureReadingEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bloodPressureReadingDao(): BloodPressureReadingDao
}