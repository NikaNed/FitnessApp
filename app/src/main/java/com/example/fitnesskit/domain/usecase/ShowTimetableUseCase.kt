package com.example.fitnesskit.domain.usecase

import com.example.fitnesskit.domain.repository.FitnessRepository
import javax.inject.Inject

class ShowTimetableUseCase @Inject constructor(
    private val repository: FitnessRepository
) {
    suspend operator fun invoke() = repository.getTimetableInfo()
}