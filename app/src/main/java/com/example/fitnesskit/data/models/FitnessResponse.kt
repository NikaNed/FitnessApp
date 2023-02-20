package com.example.fitnesskit.data.models

import com.google.gson.annotations.SerializedName

data class FitnessResponse(
    @SerializedName("lessons")
    val lessons: List<LessonDto>,
    @SerializedName("option")
    val option: OptionDto,
    @SerializedName("tabs")
    val tabs: List<TabDto>,
    @SerializedName("trainers")
    val trainers: List<TrainerDto>
)