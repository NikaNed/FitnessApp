package com.example.fitnesskit.data.models

import com.google.gson.annotations.SerializedName

data class TrainerDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("full_name")
    val full_name: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image_url")
    val image_url: String,
    @SerializedName("image_url_medium")
    val image_url_medium: String,
    @SerializedName("image_url_small")
    val image_url_small: String,
    @SerializedName("last_name")
    val last_name: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String
)