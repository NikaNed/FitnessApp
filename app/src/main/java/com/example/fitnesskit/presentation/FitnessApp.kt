package com.example.fitnesskit.presentation

import android.app.Application
import com.example.fitnesskit.di.DaggerApplicationComponent

class FitnessApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}
