package com.example.fitnesskit.data.models

import com.google.gson.annotations.SerializedName

data class OptionDto(
    @SerializedName("club_name")
    val club_name: String,
    @SerializedName("link_android")
    val link_android: String,
    @SerializedName("link_ios")
    val link_ios: String,
    @SerializedName("primary_color")
    val primary_color: String,
    @SerializedName("secondary_color")
    val secondary_color: String
)