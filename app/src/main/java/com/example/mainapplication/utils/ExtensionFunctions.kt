package com.example.mainapplication.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
inline fun <VM: ViewModel> viewModelFactory(
    crossinline block: () -> VM) = object: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return block() as T
    }
}

inline fun <reified T : ViewModel> AppCompatActivity.makeViewModel(factory: ViewModelProvider.Factory? = null): T {
    return ViewModelProvider(this, factory!!).get(T::class.java)
}