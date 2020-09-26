package com.example.mainapplication.domain

import com.example.mainapplication.core.DetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DetailService {

    @GET("/api/json/v1/1/lookup.php")
    fun getDetailMeal(@Query("i") i: String): Call<DetailResponse>
}