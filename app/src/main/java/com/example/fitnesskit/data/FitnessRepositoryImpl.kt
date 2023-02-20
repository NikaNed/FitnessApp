package com.example.fitnesskit.data

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.fitnesskit.data.mapper.Mapper
import com.example.fitnesskit.domain.repository.FitnessRepository
import com.example.fitnesskit.domain.entities.TimetableItem
import javax.inject.Inject

class FitnessRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Mapper
) : FitnessRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getTimetableInfo(): List<TimetableItem>? {
        return try {
            val response = apiService.getTimetableInfo()
            response.lessons.map {
                mapper.mapDtoToEntityTimetableItem(it, response.trainers)
            }
        } catch (e: Exception) {
            Log.d("TAG", e.message.toString())
            null
        }
    }
}
