package com.example.fitnesskit.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fitnesskit.R
import com.example.fitnesskit.databinding.ActivityMainBinding
import com.example.fitnesskit.presentation.fragments.*

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {

            launchFragment(TimetableFragment.newInstance(), R.id.main_container)

            binding.navBottom.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.lessonsFragment -> {
                        launchFragment(TimetableFragment.newInstance(), R.id.main_container)
                    }
                    R.id.requestFragment -> {
                        launchFragment(RequestFragment.newInstance(), R.id.main_container)
                    }
                    R.id.addFragment -> {
                        launchFragment(AddFragment.newInstance(), R.id.main_container)
                    }
                    R.id.chatFragment -> {
                        launchFragment(ChatFragment.newInstance(), R.id.main_container)
                    }
                    R.id.moreFragment -> {
                        launchFragment(MoreFragment.newInstance(), R.id.main_container)
                    }
                }
                true
            }
        }
    }

    private fun launchFragment(fragment: Fragment, idHolder: Int) {
        supportFragmentManager.beginTransaction()
            .replace(idHolder, fragment)
            .commit()
    }
}