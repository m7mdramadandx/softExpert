package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.repo.CarsRepository

class ViewModelFactory(private val carRepository: CarsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CarsViewModel::class.java)) {
            return CarsViewModel(carRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}

