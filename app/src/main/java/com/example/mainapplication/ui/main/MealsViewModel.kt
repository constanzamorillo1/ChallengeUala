package com.example.mainapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mainapplication.domain.MealsRepository
import com.example.mainapplication.domain.RepositoryResult
import com.example.mainapplication.utils.State

class MealsViewModel(private val repository: MealsRepository) : ViewModel() {

    private val _meals = MutableLiveData<State>()
    private val _loading = MutableLiveData<State.Loading>()
    private val _error = MutableLiveData<State>()

    val meals: LiveData<State>
        get() = _meals

    val loading: LiveData<State.Loading>
        get() = _loading

    val error: LiveData<State>
        get() = _error

    fun getMeals(s: String) {
        _loading.postValue(State.Loading.Show)
        repository.getMeals(s) {
            when(val response = it) {
                is RepositoryResult.Success -> {
                    _meals.postValue(State.MealSuccessState(response.value))
                }
                is RepositoryResult.ErrorWithCode -> {
                    _error.postValue(State.ErrorState(response.statusCode))
                }
            }
            _loading.postValue(State.Loading.Hide)
        }
    }
}