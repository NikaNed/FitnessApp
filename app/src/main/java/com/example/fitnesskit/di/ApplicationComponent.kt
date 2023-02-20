package com.example.fitnesskit.di

import android.app.Application
import com.example.fitnesskit.presentation.FitnessApp
import com.example.fitnesskit.presentation.fragments.TimetableFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, ViewModelModule::class])
@ApplicationScope
interface ApplicationComponent {

    fun inject(fragment: TimetableFragment)
    fun inject(application: FitnessApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

}