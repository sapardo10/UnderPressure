package com.anarkio.hema.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BloodPressureReadingDao {
    @Query("SELECT * FROM blood_pressure_reading")
    fun getAll(): Flow<List<BloodPressureReadingEntity>>

    @Insert
    fun insert(bloodPressureReadingEntity: BloodPressureReadingEntity)

    @Delete
    fun delete(bloodPressureReadingEntity: BloodPressureReadingEntity)
}