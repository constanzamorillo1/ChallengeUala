package com.example.mainapplication.domain

import com.example.mainapplication.core.DetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailRepository: AbstractRepository<DetailService>(DetailService::class.java) {

    fun getDetailMeal(i: String, block: (RepositoryResult<DetailResponse>) -> Unit) {
        service.getDetailMeal(i).enqueue(getCallBack(block))
    }

    private fun getCallBack(block: (RepositoryResult<DetailResponse>) -> Unit) = object: Callback<DetailResponse> {
        override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
            block(RepositoryResult.ErrorWithCode(t.hashCode()))
        }

        override fun onResponse(call: Call<DetailResponse>, response: Response<DetailResponse>) {
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