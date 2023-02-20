package com.example.fitnesskit.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskit.databinding.ItemTimetableBinding
import com.example.fitnesskit.domain.entities.TimetableItem


class TimetableViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemTimetableBinding.bind(view)

    fun bind(item: TimetableItem, dateVisibility: Boolean) = with(binding) {
        with(item) {
            val timeStart = startTime
            val timeEnd = endTime
            tvNameLesson.text = name
            tvTimeStart.text = timeStart
            tvTimeEnd.text = timeEnd
            viewLine.setBackgroundColor(item.color.toInt())
            tvDate.text = date
            tvLocation.text = item.place
            tvTrainerName.text = item.full_name
            tvTime.text = item.time
            tvDate.visibility = if (dateVisibility) { View.VISIBLE } else View.GONE
        }
    }
}






