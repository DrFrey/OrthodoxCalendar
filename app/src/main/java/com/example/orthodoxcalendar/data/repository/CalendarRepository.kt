package com.example.orthodoxcalendar.data.repository

import com.example.orthodoxcalendar.data.storage.models.DateRuleLocal
import com.example.orthodoxcalendar.data.storage.models.DayLocal
import com.example.orthodoxcalendar.data.storage.models.HolidayLocal
import com.example.orthodoxcalendar.data.storage.models.SaintLocal
import kotlinx.coroutines.flow.Flow

interface CalendarRepository {

    fun getCacheDate(
        dateBefore: String?,
        dateStrictlyBefore: String?,
        dateAfter: String?,
        dateStrictlyAfter: String?
    ): Flow<Result<List<DateRuleLocal>>>

    fun getDay(date: String): Flow<Result<DayLocal>>

    fun getHoliday(id: Int): Flow<Result<HolidayLocal>>

    fun getSaint(id: Int): Flow<Result<SaintLocal>>
}