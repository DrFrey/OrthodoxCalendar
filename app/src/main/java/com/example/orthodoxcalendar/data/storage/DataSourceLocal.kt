package com.example.orthodoxcalendar.data.storage

import com.example.orthodoxcalendar.data.storage.models.HolidayLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataSourceLocal @Inject constructor(private val db: AppDatabase) {

    suspend fun getHoliday(id: Int): HolidayLocal = db.holidayDao().getHolidayById(id)

    suspend fun insertHoliday(holidayLocal: HolidayLocal) =
        db.holidayDao().insertHolidayInTransaction(
            body = holidayLocal.body,
            icons = holidayLocal.icons,
            troparia = holidayLocal.tropariaOrKontakia
        )
}