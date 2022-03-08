package com.example.orthodoxcalendar.common

import android.util.Log
import retrofit2.HttpException
import retrofit2.Response
import com.example.orthodoxcalendar.data.repository.Result

const val TAG = "NetworkUtils"

inline fun <T> request(
    call: () -> Response<T>
): Result<T> {
    return try {
        val response = call.invoke()
        when (response.isSuccessful) {
            true -> Result.Success(response.body())
            false -> Result.Error(HttpException(response))
                .also { Log.w(TAG, "Unsuccessful response: $response") }
        }
    } catch (exception: Throwable) {
        Log.e(TAG, exception.toString())
        Result.Error(exception)
    }
}
