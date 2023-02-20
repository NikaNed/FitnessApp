package com.example.fitnesskit.data

import com.example.fitnesskit.data.models.FitnessResponse
import retrofit2.http.GET

interface ApiService {

    @GET("?club_id=2")
    suspend fun getTimetableInfo(): FitnessResponse
}