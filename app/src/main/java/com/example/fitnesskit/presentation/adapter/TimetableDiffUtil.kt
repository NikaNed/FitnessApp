package com.example.fitnesskit.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.fitnesskit.domain.entities.TimetableItem

object TimetableDiffUtil: DiffUtil.ItemCallback<TimetableItem>() {
    override fun areItemsTheSame(oldItem: TimetableItem, newItem: TimetableItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TimetableItem, newItem: TimetableItem): Boolean {
        return oldItem == newItem
    }
}
