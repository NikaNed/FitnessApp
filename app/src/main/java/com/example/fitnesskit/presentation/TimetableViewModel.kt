package com.example.fitnesskit.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesskit.domain.entities.State
import com.example.fitnesskit.domain.usecase.ShowTimetableUseCase
import com.example.fitnesskit.domain.entities.TimetableItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class TimetableViewModel @Inject constructor(
    private val showTimetableUseCase: ShowTimetableUseCase
) : ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    fun getFitnessTimetable() {

        viewModelScope.launch {

            _state.value = State.Progress
            val response = showTimetableUseCase.invoke()
            _state.value = State.LoadData(response?.sortedBy { it.dateSorted })
        }
    }
}