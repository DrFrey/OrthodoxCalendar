package com.example.orthodoxcalendar.data.remote

import com.example.orthodoxcalendar.data.remote.mappers.CacheDateMapper
import com.example.orthodoxcalendar.data.remote.mappers.DayMapper
import com.example.orthodoxcalendar.common.request
import com.example.orthodoxcalendar.data.remote.mappers.HolidayMapper
import com.example.orthodoxcalendar.data.storage.models.DateRuleLocal
import com.example.orthodoxcalendar.data.storage.models.DayLocal
import com.example.orthodoxcalendar.data.repository.map
import javax.inject.Inject
import com.example.orthodoxcalendar.data.repository.Result
import com.example.orthodoxcalendar.data.storage.models.HolidayLocal

class DataSourceRemote @Inject constructor(
    private val calendarApiService: CalendarApiService,
    private val cacheDateMapper: CacheDateMapper,
    private val dayMapper: DayMapper,
    private val holidayMapper: HolidayMapper
){
        suspend fun getCacheDates(
            dateBefore: String?,
            dateStrictlyBefore: String?,
            dateAfter: String?,
            dateStrictlyAfter: String?
        ): Result<List<DateRuleLocal>> =
            request {
                calendarApiService.getCacheDates(dateBefore, dateStrictlyBefore, dateAfter, dateStrictlyAfter)
            }.map {
                cacheDateMapper.mapToLocal(it)
            }

    suspend fun getDay(date: String): Result<DayLocal> =
        request {
            calendarApiService.getDay(date)
        }.map {
            dayMapper.mapToLocal(it)
        }

    suspend fun getHoliday(id: Int): Result<HolidayLocal> =
        request {
            calendarApiService.getHoliday(id)
        }.map {
            holidayMapper.mapToLocal(
                it,
                it.iconsOfHolidays ?: listOf(),
                it.tropariaOrKontakia ?: listOf())
        }
}