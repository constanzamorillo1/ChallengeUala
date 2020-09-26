package com.example.mainapplication.core

import com.google.gson.annotations.SerializedName

data class DetailResponse (
    @SerializedName("meals") val meals: List<DetailMealModel>
)