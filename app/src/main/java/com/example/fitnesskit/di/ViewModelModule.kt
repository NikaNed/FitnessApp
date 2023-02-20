package com.example.fitnesskit.di

import androidx.lifecycle.ViewModel
import com.example.fitnesskit.presentation.TimetableViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(TimetableViewModel::class)
    @Binds
    fun bindTimetableViewModel(viewModel: TimetableViewModel): ViewModel
}