package com.example.myapplication.repo

import com.example.myapplication.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CarsRepository(private val apiService: ApiService) {

    suspend fun retrieveCars(pageNumber: Int) =
        withContext(Dispatchers.IO) {
            apiService.retrieveCars(pageNumber)
        }
}