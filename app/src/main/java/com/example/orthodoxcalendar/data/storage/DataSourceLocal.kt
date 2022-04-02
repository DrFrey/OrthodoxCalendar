package com.example.orthodoxcalendar.data.storage

import com.example.orthodoxcalendar.data.storage.models.HolidayLocal
import com.example.orthodoxcalendar.data.storage.models.SaintLocal
import javax.inject.Inject

class DataSourceLocal @Inject constructor(private val db: AppDatabase) {

    suspend fun getHoliday(id: Int): HolidayLocal = db.holidayDao().getHolidayById(id)

    suspend fun insertHoliday(holidayLocal: HolidayLocal) =
        db.holidayDao().insertHolidayInTransaction(
            body = holidayLocal.body,
            icons = holidayLocal.icons,
            troparia = holidayLocal.troparia
        )

    suspend fun getSaint(id: Int): SaintLocal = db.saintDao().getSaintById(id)

    suspend fun insertSaint(saintLocal: SaintLocal) =
        db.saintDao().insertSaintInTransaction(
            body = saintLocal.body,
            icons = saintLocal.icons,
            troparia = saintLocal.troparia
        )
}