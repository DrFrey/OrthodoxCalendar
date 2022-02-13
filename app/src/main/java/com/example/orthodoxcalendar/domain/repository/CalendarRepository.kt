package com.example.orthodoxcalendar.domain.repository

import com.example.orthodoxcalendar.domain.models.DateRuleLocal
import com.example.orthodoxcalendar.domain.models.DayLocal
import kotlinx.coroutines.flow.Flow

interface CalendarRepository {

    fun getCacheDate(
        dateBefore: String?,
        dateStrictlyBefore: String?,
        dateAfter: String?,
        dateStrictlyAfter: String?
    ): Flow<Result<List<DateRuleLocal>>>

    fun getDay(date: String): Flow<Result<DayLocal>>
}