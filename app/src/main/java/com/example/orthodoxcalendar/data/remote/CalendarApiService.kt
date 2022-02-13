package com.example.orthodoxcalendar.data.remote

import com.example.orthodoxcalendar.data.remote.model.CacheDateResponse
import com.example.orthodoxcalendar.data.remote.model.DayResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CalendarApiService {

    @GET("days/api/cache_dates")
    suspend fun getCacheDates(
        @Query("date[before]") dateBefore: String?,
        @Query("date[strictly_before]") dateStrictlyBefore: String?,
        @Query("date[after]") dateAfter: String?,
        @Query("date[strictly_after]") dateStrictlyAfter: String?
    ): Response<CacheDateResponse>

    @GET("days-new/api/day/{date}.json")
    suspend fun getDay(@Path("date") date: String): Response<DayResponse>
}