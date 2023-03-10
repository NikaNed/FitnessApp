package com.example.fitnesskit.data.models

import com.google.gson.annotations.SerializedName

data class TabDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)