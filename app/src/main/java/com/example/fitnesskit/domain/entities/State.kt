package com.example.fitnesskit.domain.entities

sealed class State {

    class LoadData(val response: List<TimetableItem>?) : State()
    object Progress : State()
}


