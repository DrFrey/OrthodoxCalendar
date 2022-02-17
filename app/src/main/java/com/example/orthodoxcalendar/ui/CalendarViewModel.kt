package com.example.orthodoxcalendar.ui

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orthodoxcalendar.common.YYYY_MM_DD
import com.example.orthodoxcalendar.common.D_MMMM
import com.example.orthodoxcalendar.common.convertLongToDate
import com.example.orthodoxcalendar.domain.models.DateRuleLocal
import com.example.orthodoxcalendar.domain.models.DayLocal
import com.example.orthodoxcalendar.domain.repository.CalendarRepository
import com.example.orthodoxcalendar.domain.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.collect

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val calendarRepository: CalendarRepository
): ViewModel() {

    private var currentDate = System.currentTimeMillis()

    var currentDateFormatted by mutableStateOf("")
        private set

    var currentDateItems = mutableStateListOf<DateRuleLocal>()
        private set

    var saintItems = mutableStateListOf<DayLocal.Saint>()
        private set

    var holidayItems = mutableStateListOf<DayLocal.Holiday>()
        private set

    var iconItems = mutableStateListOf<DayLocal.Icon?>(null)
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
        setFormattedDate()
        getCurrentDay()
    }

    private fun setFormattedDate() {
        currentDateFormatted = currentDate.convertLongToDate(D_MMMM)
//        currentDateFormatted = "7 января"
    }

    private fun getCurrentDay() {
        val date = currentDate.convertLongToDate(YYYY_MM_DD)
        viewModelScope.launch {
            calendarRepository.getDay(date)
                .collect {
                    when(it) {
                        is Result.Loading -> {
                            isLoading = true
                        }
                        is Result.Success -> {
                            isLoading = false
                            fasting = it.data?.fastings?.toMutableStateList() ?: mutableStateListOf()
                            saintItems = it.data?.saints?.toMutableStateList() ?: mutableStateListOf()
                            textItems = it.data?.texts?.toMutableStateList() ?: mutableStateListOf()
                            iconItems = it.data?.icons?.toMutableStateList() ?: mutableStateListOf()
                            holidayItems = it.data?.holidays?.toMutableStateList() ?: mutableStateListOf()
                        }
                        is Result.Error -> {
                            error = it.message.orEmpty()
                            isLoading = false
                        }
                    }
                }
        }
    }

    private fun getCurrentDateItems() {
        val date = currentDate.convertLongToDate(YYYY_MM_DD)
        viewModelScope.launch {
            calendarRepository.getCacheDate(dateBefore = date, dateStrictlyBefore = null, dateAfter = date, dateStrictlyAfter = null)
                .collect {
                    when(it) {
                        is Result.Loading -> isLoading = true
                        is Result.Success -> {
                            currentDateItems = it.data?.toMutableStateList() ?: mutableStateListOf()
                            isLoading = false
                        }
                        is Result.Error -> {
                            error = it.message.orEmpty()
                            isLoading = false
                        }
                    }
                }
        }
    }
}