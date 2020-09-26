package com.example.mainapplication.domain

import com.example.mainapplication.core.MealsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsService {

    @GET("api/json/v1/1/search.php")
    fun getMeals(@Query("s") s: String): Call<MealsResponse>
}