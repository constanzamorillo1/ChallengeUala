package com.example.mainapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mainapplication.domain.MealsRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mealViewModel: MealsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mealViewModel = ViewModelProvider(this, ViewModelFactory(MealsRepository())).get(MealsViewModel::class.java)
        init()
    }

    private fun init() {
        initObservers()
        setComponents()
    }

    private fun setComponents() {
        searchText.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { text ->
                    if (text.isNotEmpty()) {
                        mealViewModel.getMeals(text)
                    }
                }
                return false
            }
        })
    }

    private fun initObservers() {
        mealViewModel.meals.observe(this, Observer {
            when(val state = it) {
                is State.SuccessState -> {
                    Log.d("meals", state.value.meals.toString())
                }
            }
        })

        mealViewModel.loading.observe(this, Observer {

        })

        mealViewModel.error.observe(this, Observer {

        })
    }

    companion object {
        private const val ZERO = 0
    }
}