package com.example.mainapplication.domain

import com.example.mainapplication.core.MealsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository : AbstractRepository<MealsService>(MealsService::class.java) {

    fun getMeals(s: String, block: (RepositoryResult<MealsResponse>) -> Unit) {
        service.getMeals(s).enqueue(getCallBack(block))
    }

    private fun getCallBack(block: (RepositoryResult<MealsResponse>) -> Unit) = object: Callback<MealsResponse> {
        override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
            block(RepositoryResult.ErrorWithCode(t.hashCode()))
        }

        override fun onResponse(call: Call<MealsResponse>, response: Response<MealsResponse>) {
            if (response.isSuccessful) {
                response.body()?.let {
                    block(RepositoryResult.Success(it))
                }
            } else {
                block(RepositoryResult.ErrorWithCode(response.code()))
            }
        }
    }
}