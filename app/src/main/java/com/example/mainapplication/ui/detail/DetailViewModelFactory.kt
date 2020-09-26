package com.example.mainapplication.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mainapplication.domain.DetailRepository

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(
    private val repository: DetailRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(repository) as T
    }
}