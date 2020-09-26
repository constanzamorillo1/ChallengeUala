package com.example.mainapplication.ui.main

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