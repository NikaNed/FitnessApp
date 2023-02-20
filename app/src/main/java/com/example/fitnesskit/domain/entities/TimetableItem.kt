package com.example.fitnesskit.domain.entities

import java.util.UUID

data class TimetableItem(
    val name: String,
    val place: String,
    val startTime: String,
    val endTime: String,
    val date: String,
    val color: String,
    val full_name: String = "",
    val time: String,
    val id: UUID,
    val dateSorted: String
)
