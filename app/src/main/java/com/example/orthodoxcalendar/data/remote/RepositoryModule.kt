package com.example.orthodoxcalendar.data.remote

import android.content.Context
import androidx.room.Room
import com.example.orthodoxcalendar.data.repository.CalendarRepository
import com.example.orthodoxcalendar.data.repository.CalendarRepositoryImpl
import com.example.orthodoxcalendar.data.storage.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideCalendarRepository(dataSourceRemote: DataSourceRemote): CalendarRepository {
        return CalendarRepositoryImpl(dataSourceRemote)
    }
}

@Singleton
@Provides
fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
    return Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "OrthodoxCalendarDB"
    ).fallbackToDestructiveMigration()
        .build()
}