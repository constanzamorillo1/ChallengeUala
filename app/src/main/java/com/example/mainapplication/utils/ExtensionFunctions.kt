package com.example.mainapplication.utils

import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*

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

open class DebouncingQueryTextListener(
    private val onDebouncingQueryTextChange: (String?) -> Unit
) : SearchView.OnQueryTextListener {
    var debouncePeriod: Long = 500

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    private var searchJob: Job? = null

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        searchJob?.cancel()
        searchJob = coroutineScope.launch {
            newText?.let { text ->
                delay(debouncePeriod)
                onDebouncingQueryTextChange(text)
            }
        }
        return false
    }

}