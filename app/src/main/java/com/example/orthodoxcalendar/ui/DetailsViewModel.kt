package com.example.orthodoxcalendar.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orthodoxcalendar.data.repository.CalendarRepository
import com.example.orthodoxcalendar.data.repository.Result
import com.example.orthodoxcalendar.data.storage.models.HolidayLocal
import com.example.orthodoxcalendar.data.storage.models.SaintLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val calendarRepository: CalendarRepository
) : ViewModel() {
    var error by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    var holidayData by mutableStateOf<HolidayLocal?>(null)
        private set

    var saintData by mutableStateOf<SaintLocal?>(null)
        private set

    fun getHoliday(id: Int) {
        viewModelScope.launch {
            calendarRepository.getHoliday(id).collect {
                when (it) {
                    is Result.Loading -> {
                        isLoading = true
                    }
                    is Result.Success -> {
                        isLoading = false
                        holidayData = it.data
                    }
                    is Result.Error -> {
                        error = it.message.orEmpty()
                        isLoading = false
                    }
                }
            }
        }
    }

    fun getSaint(id: Int) {
        viewModelScope.launch {
            calendarRepository.getSaint(id).collect {
                when (it) {
                    is Result.Loading -> {
                        isLoading = true
                    }
                    is Result.Success -> {
                        isLoading = false
                        saintData = it.data
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