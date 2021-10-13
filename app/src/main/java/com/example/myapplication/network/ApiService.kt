package com.example.myapplication.network

import androidx.lifecycle.LiveData
import com.example.myapplication.model.CarResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET("v1/cars?")
    suspend fun retrieveCars(@Query("page") pageNumber: Int): LiveData<CarResponse>

}