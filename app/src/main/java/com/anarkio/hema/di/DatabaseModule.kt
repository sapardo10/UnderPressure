package com.anarkio.hema.di

import android.content.Context
import androidx.room.Room
import com.anarkio.hema.database.AppDatabase
import com.anarkio.hema.database.BloodPressureReadingDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "HemaDatabase"
        ).build()
    }

    @Provides
    fun provideBloodPressureReadingDao(appDatabase: AppDatabase): BloodPressureReadingDao {
        return appDatabase.bloodPressureReadingDao()
    }
}