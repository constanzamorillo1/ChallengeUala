package com.example.mainapplication.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainapplication.R
import com.example.mainapplication.domain.MealsRepository
import com.example.mainapplication.ui.detail.DetailMealActivity
import com.example.mainapplication.utils.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var mealViewModel: MealsViewModel
    private lateinit var mealsAdapter: MealsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mealViewModel = makeViewModel(MealsViewModel.factory())
        init()
    }

    private fun init() {
        initObservers()
        setComponents()
    }

    private fun setComponents() {
        searchText.setOnQueryTextListener(DebouncingQueryTextListener { text ->
            text?.let {
                if (text.isNotEmpty()) {
                    mealViewModel.getMeals(text)
                } else
                    mealsAdapter.updateData(emptyList())
            }
        })
        mealsAdapter = MealsAdapter(emptyList())
        mealsAdapter.setListener(object: ClickListener {
            override fun onClickItem(id: String) {
                val intent = Intent(this@MainActivity, DetailMealActivity::class.java)
                intent.putExtra(ID, id)
                startActivity(intent)
            }
        })

        recyclerMeals.adapter = mealsAdapter
        recyclerMeals.layoutManager = LinearLayoutManager(this)
        recyclerMeals.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun initObservers() {
        mealViewModel.meals.observe(this, Observer {
            when(val state = it) {
                is State.MealSuccessState -> {
                    mealsAdapter.updateData(state.value.meals)
                }
            }
        })

        mealViewModel.error.observe(this, Observer {

        })
    }

    companion object {
        private const val ID = "ID"
    }
}