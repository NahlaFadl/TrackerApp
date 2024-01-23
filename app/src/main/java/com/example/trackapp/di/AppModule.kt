package com.example.trackapp.di

import android.content.Context
import androidx.room.Room
import com.example.trackapp.db.RunningDatabase
import com.example.trackapp.other.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Provides
    fun provideRunDao(db: RunningDatabase) = db.getRunDao()
}