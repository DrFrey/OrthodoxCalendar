package com.example.orthodoxcalendar.domain.repository

import com.example.orthodoxcalendar.data.remote.DataSourceRemote
import com.example.orthodoxcalendar.domain.models.DateRuleLocal
import com.example.orthodoxcalendar.domain.models.DayLocal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CalendarRepositoryImpl(
    private val dataSourceRemote: DataSourceRemote
) : CalendarRepository {

    override fun getCacheDate(
        dateBefore: String?,
        dateStrictlyBefore: String?,
        dateAfter: String?,
        dateStrictlyAfter: String?
    ): Flow<Result<List<DateRuleLocal>>> {
        return flow {
            emit(Result.Loading)
            val calendarResponse = dataSourceRemote.getCacheDates(dateBefore, dateStrictlyBefore, dateAfter, dateStrictlyAfter)
            emit(calendarResponse)
        }.flowOn(Dispatchers.IO)
    }

    override fun getDay(date: String): Flow<Result<DayLocal>> {
        return flow {
            emit(Result.Loading)
            val dayResponse = dataSourceRemote.getDay(date)
            emit(dayResponse)
        }.flowOn(Dispatchers.IO)
    }
}