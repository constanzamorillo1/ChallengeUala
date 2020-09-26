package com.example.mainapplication.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mainapplication.domain.DetailRepository
import com.example.mainapplication.domain.RepositoryResult
import com.example.mainapplication.utils.State

class DetailViewModel(private val repository: DetailRepository): ViewModel() {

    private val _meal = MutableLiveData<State>()
    private val _error = MutableLiveData<State.ErrorState>()

    val meal: LiveData<State>
        get() = _meal

    fun getDetailMeal(i: String) {
        repository.getDetailMeal(i) {
            when(val response = it) {
                is RepositoryResult.Success ->
                    _meal.postValue(State.DetailSuccessState(response.value))
                is RepositoryResult.ErrorWithCode ->
                    _error.postValue(State.ErrorState(response.statusCode))
            }
        }
    }
}

