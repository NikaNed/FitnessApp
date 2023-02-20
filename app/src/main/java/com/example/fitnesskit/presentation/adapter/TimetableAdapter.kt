package com.example.fitnesskit.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.fitnesskit.R
import com.example.fitnesskit.domain.entities.TimetableItem

class TimetableAdapter : ListAdapter<TimetableItem, TimetableViewHolder>(TimetableDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetableViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_timetable,
            parent,
            false
        )
        return TimetableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimetableViewHolder, position: Int) {
        val item = currentList[position]

        if (position != 0) {
            val prevItem = currentList[position - 1]
            if (item.date == prevItem.date) {
                holder.bind(getItem(position), false)
            } else {
                holder.bind(getItem(position), true)
            }
        } else {
            holder.bind(getItem(position), true)
        }
    }
}