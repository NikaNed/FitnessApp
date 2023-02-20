package com.example.fitnesskit.data.mapper

import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.fitnesskit.data.models.LessonDto
import com.example.fitnesskit.data.models.TrainerDto
import com.example.fitnesskit.domain.entities.TimetableItem
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalTime
import java.util.*
import javax.inject.Inject

class Mapper @Inject constructor() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun mapDtoToEntityTimetableItem(lesson: LessonDto, trainers: List<TrainerDto>): TimetableItem {
        val startTime = lesson.startTime.let { LocalTime.parse(it) }
        val endTime = lesson.endTime.let { LocalTime.parse(it) }
        return TimetableItem(
            startTime = startTime.toString(),
            endTime = endTime.toString(),
            name = lesson.name,
            time = durationTime(startTime, endTime),
            full_name = trainers.find { it.id == lesson.coach_id }?.full_name.toString(),
            place = lesson.place,
            date = mapDate(lesson.date),
            color = lesson.color.let { Color.parseColor(it) }.toString(),
            id = UUID.randomUUID(),
            dateSorted = lesson.date + lesson.startTime
        )
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun durationTime(time1: LocalTime?, time2: LocalTime?): String {
        val time = Duration.between(time1, time2)
        return time.toString()
            .replace("PT", "")
            .replace("H", "ч. ")
            .replace("M", "мин.")
    }

    private fun mapDate(date: String): String {
        val dateObject = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date)
        val formatter = SimpleDateFormat("EEEE, dd MMMM", Locale.getDefault())
        return formatter.format(dateObject)
    }
}