package com.anarkio.hema.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BloodPressureReadingDao {
    @Query("SELECT * FROM blood_pressure_reading")
    fun getAll(): List<BloodPressureReadingEntity>

    @Insert
    fun insert(bloodPressureReadingEntity: BloodPressureReadingEntity)

    @Delete
    fun delete(bloodPressureReadingEntity: BloodPressureReadingEntity)
}