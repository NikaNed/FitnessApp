package com.example.fitnesskit.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesskit.domain.usecase.ShowTimetableUseCase
import com.example.fitnesskit.domain.entities.TimetableItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class TimetableViewModel @Inject constructor(
    private val showTimetableUseCase: ShowTimetableUseCase
) : ViewModel() {

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    private val _timetableInfo = MutableLiveData<List<TimetableItem>>()
    val timetableInfo: LiveData<List<TimetableItem>>
        get() = _timetableInfo


    fun getFitnessTimetable() {

        viewModelScope.launch {

            _progressBar.value = true
            val response = showTimetableUseCase.invoke()
            _timetableInfo.value = response?.sortedBy {it.dateSorted}
            _progressBar.value = false
        }
    }
}