package com.example.fitnesskit.domain.repository

import com.example.fitnesskit.domain.entities.TimetableItem

interface FitnessRepository {

    suspend fun getTimetableInfo(): List<TimetableItem>?
}