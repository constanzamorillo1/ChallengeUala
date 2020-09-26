package com.example.mainapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var mealViewModel: MealsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mealViewModel = ViewModelProvider(this).get(MealsViewModel::class.java)
        init()
    }

    private fun init() {

    }
}