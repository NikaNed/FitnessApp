package com.example.fitnesskit.data.models

import com.google.gson.annotations.SerializedName

data class LessonDto(
    @SerializedName("appointment_id")
    val appointment_id: String,
    @SerializedName("available_slots")
    val available_slots: Int,
    @SerializedName("client_recorded")
    val client_recorded: Boolean,
    @SerializedName("coach_id")
    val coach_id: String,
    @SerializedName("color")
    val color: String,
    @SerializedName("commercial")
    val commercial: Boolean,
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("endTime")
    val endTime: String,
    @SerializedName("is_cancelled")
    val is_cancelled: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("place")
    val place: String,
    @SerializedName("service_id")
    val service_id: String,
    @SerializedName("startTime")
    val startTime: String,
    @SerializedName("tab")
    val tab: String,
    @SerializedName("tab_id")
    val tab_id: Int
)