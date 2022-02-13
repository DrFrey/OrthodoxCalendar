package com.example.orthodoxcalendar.data.remote

import com.example.orthodoxcalendar.domain.repository.CalendarRepository
import com.example.orthodoxcalendar.domain.repository.CalendarRepositoryImpl
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
    fun provideCalendarRepository(dataSourceRemote: DataSourceRemote): CalendarRepository {
        return CalendarRepositoryImpl(dataSourceRemote)
    }
}