package com.anarkio.hema.di

import com.anarkio.hema.data.datasources.IBloodPressureReadingLocalDataSource
import com.anarkio.hema.database.BloodPressureReadingDao
import com.anarkio.hema.database.BloodPressureReadingLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    fun provideBloodPressureReadingLocalDataSource(
        bloodPressureReadingDao: BloodPressureReadingDao
    ): IBloodPressureReadingLocalDataSource {
        return BloodPressureReadingLocalDataSource(
            bloodPressureReadingDao = bloodPressureReadingDao
        )
    }
}