package com.example.orthodoxcalendar.data.remote

import com.example.orthodoxcalendar.data.remote.model.DayResponse
import com.example.orthodoxcalendar.data.remote.model.HolidayResponse
import com.example.orthodoxcalendar.data.remote.model.SaintResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CalendarApiService {

    @GET("days/api/day/{date}.json")
    suspend fun getDay(@Path("date") date: String): Response<DayResponse>

    @GET("days/api/holidays/{id}")
    suspend fun getHoliday(@Path("id") id: Int): Response<HolidayResponse>

    @GET("days/api/saints/{id}")
    suspend fun getSaint(@Path("id") id: Int): Response<SaintResponse>
}