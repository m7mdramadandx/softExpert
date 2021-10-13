package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class CarModel(
    @SerializedName("id") val carID: String?,
    @SerializedName("brand") val brand: String?,
    //constractionYear -> constructionYear
    @SerializedName("constractionYear") val constructionYear: String?,
    @SerializedName("isUsed") val isUsed: Boolean?,
    @SerializedName("imageUrl") val imageUrl: String?,
)
