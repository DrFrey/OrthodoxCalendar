package com.example.orthodoxcalendar.data.remote

import com.example.orthodoxcalendar.data.remote.mappers.CacheDateMapper
import com.example.orthodoxcalendar.data.remote.mappers.DayMapper
import com.example.orthodoxcalendar.common.request
import com.example.orthodoxcalendar.domain.models.DateRuleLocal
import com.example.orthodoxcalendar.domain.models.DayLocal
import com.example.orthodoxcalendar.domain.repository.map
import javax.inject.Inject
import com.example.orthodoxcalendar.domain.repository.Result

class DataSourceRemote @Inject constructor(
    private val calendarApiService: CalendarApiService,
    private val cacheDateMapper: CacheDateMapper,
    private val dayMapper: DayMapper
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
}