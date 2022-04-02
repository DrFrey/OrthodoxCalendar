package com.example.orthodoxcalendar.data.repository

import com.example.orthodoxcalendar.data.remote.DataSourceRemote
import com.example.orthodoxcalendar.data.storage.DataSourceLocal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideCalendarRepository(
        dataSourceRemote: DataSourceRemote,
        dataSourceLocal: DataSourceLocal
    ): CalendarRepository {
        return CalendarRepositoryImpl(dataSourceRemote, dataSourceLocal)
    }
}

