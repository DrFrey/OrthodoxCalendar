package com.example.orthodoxcalendar.data.repository

import com.example.orthodoxcalendar.data.remote.DataSourceRemote
import com.example.orthodoxcalendar.data.storage.DataSourceLocal
import com.example.orthodoxcalendar.data.storage.models.DateRuleLocal
import com.example.orthodoxcalendar.data.storage.models.DayLocal
import com.example.orthodoxcalendar.data.storage.models.HolidayLocal
import com.example.orthodoxcalendar.data.storage.models.SaintLocal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CalendarRepositoryImpl(
    private val dataSourceRemote: DataSourceRemote,
    private val dataSourceLocal: DataSourceLocal
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

    override fun getHoliday(id: Int): Flow<Result<HolidayLocal>> {
        return flow {
            emit(Result.Success(dataSourceLocal.getHoliday(id)))
            emit(Result.Loading)
            val result = dataSourceRemote.getHoliday(id)
            emit(result)
            if (result is Result.Success) {
                result.data?.let {
                    dataSourceLocal.insertHoliday(result.data)
                }
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getSaint(id: Int): Flow<Result<SaintLocal>> {
        return flow {
            emit(Result.Success(dataSourceLocal.getSaint(id)))
            emit(Result.Loading)
            val result = dataSourceRemote.getSaint(id)
            emit(result)
            if (result is Result.Success) {
                result.data?.let {
                    dataSourceLocal.insertSaint(result.data)
                }
            }
        }.flowOn(Dispatchers.IO)
    }
}