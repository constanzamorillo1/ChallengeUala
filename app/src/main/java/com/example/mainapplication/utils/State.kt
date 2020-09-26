package com.example.mainapplication.utils

import com.example.mainapplication.core.DetailResponse
import com.example.mainapplication.core.MealsResponse

sealed class State {

    sealed class Loading : State() {
        object Show: Loading()
        object Hide : Loading()
    }
    data class ErrorState(val code: Int?) : State()
    data class MealSuccessState(val value: MealsResponse) : State()
    data class DetailSuccessState(val value: DetailResponse) : State()
}