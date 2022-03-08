package com.example.orthodoxcalendar.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.orthodoxcalendar.data.storage.dao.HolidayDao
import com.example.orthodoxcalendar.data.storage.models.HolidayBody
import com.example.orthodoxcalendar.data.storage.models.IconsOfHoliday
import com.example.orthodoxcalendar.data.storage.models.TropariaOrKontakia

@Database(
    entities = [HolidayBody::class, IconsOfHoliday::class, TropariaOrKontakia::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun holidayDao(): HolidayDao
}