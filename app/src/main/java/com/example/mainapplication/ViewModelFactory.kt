package com.example.mainapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mainapplication.domain.MealsRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: MealsRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MealsViewModel(repository) as T
    }
}