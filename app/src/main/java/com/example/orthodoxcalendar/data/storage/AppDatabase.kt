package com.example.orthodoxcalendar.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.orthodoxcalendar.data.storage.dao.HolidayDao
import com.example.orthodoxcalendar.data.storage.dao.SaintDao
import com.example.orthodoxcalendar.data.storage.models.*

@Database(
    entities = [HolidayBody::class, IconsOfHoliday::class, TropariaOrKontakia::class,
        SaintBody::class, IconsOfSaint::class, HolidayTropariaCrossRef::class, SaintTropariaCrossRef::class],
    version = 2
)
@TypeConverters(StringListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun holidayDao(): HolidayDao
    abstract fun saintDao(): SaintDao
}