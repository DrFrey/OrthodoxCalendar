package com.example.orthodoxcalendar.ui

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orthodoxcalendar.common.D_MMMM
import com.example.orthodoxcalendar.common.YYYY_MM_DD
import com.example.orthodoxcalendar.common.format
import com.example.orthodoxcalendar.data.repository.CalendarRepository
import com.example.orthodoxcalendar.data.repository.Result
import com.example.orthodoxcalendar.data.storage.models.DayLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val calendarRepository: CalendarRepository
) : ViewModel() {

    private var currentDate = Date()
    private val calendar: Calendar = Calendar.getInstance()

    var currentDateFormatted by mutableStateOf("")
        private set

    var saintItems = mutableStateListOf<DayLocal.Saint>()
        private set

    var holidayItems = mutableStateListOf<DayLocal.Holiday>()
        private set

    var iconItems = mutableStateListOf<DayLocal.Icon>()
        private set

    var textItems = mutableStateListOf<DayLocal.Text>()
        private set

    var fasting = mutableStateListOf<DayLocal.Fasting?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf("")
        private set

    init {
        calendar.time = currentDate
        currentDateFormatted = currentDate.format(D_MMMM)

        getCurrentDay()
    }

    private fun getCurrentDay() {
        val date = currentDate.format(YYYY_MM_DD)
        viewModelScope.launch {
            calendarRepository.getDay(date)
                .collect {
                    when (it) {
                        is Result.Loading -> {
                            isLoading = true
                        }
                        is Result.Success -> {
                            isLoading = false
                            fasting =
                                it.data?.fastings?.toMutableStateList() ?: mutableStateListOf()
                            saintItems =
                                it.data?.saints?.toMutableStateList() ?: mutableStateListOf()
                            textItems = it.data?.texts?.toMutableStateList() ?: mutableStateListOf()
                            iconItems = it.data?.icons?.toMutableStateList() ?: mutableStateListOf()
                            holidayItems =
                                it.data?.holidays?.toMutableStateList() ?: mutableStateListOf()
                        }
                        is Result.Error -> {
                            error = it.message.orEmpty()
                            isLoading = false
                        }
                    }
                }
        }
    }

    fun nextDay() {
        currentDate = calendar.apply {
            add(Calendar.DATE, 1)
        }.time
        currentDateFormatted = currentDate.format(D_MMMM)
        getCurrentDay()
        Log.d("___", "currentDate = ${currentDate.time}, formatted = ${currentDateFormatted}")
    }

    fun previousDay() {
        currentDate = calendar.apply {
            add(Calendar.DATE, -1)
        }.time
        currentDateFormatted = currentDate.format(D_MMMM)
        getCurrentDay()
        Log.d("___", "currentDate = ${currentDate.time}, formatted = ${currentDateFormatted}")
    }
}