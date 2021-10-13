package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapplication.model.Resource
import com.example.myapplication.repo.CarsRepository
import kotlinx.coroutines.Dispatchers
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class CarsViewModel(private val carsRepository: CarsRepository) : ViewModel() {

    private fun handleError(t: Throwable): String {
        return when (t) {
            is SocketTimeoutException -> ("Time out")
            is UnknownHostException -> ("No internet connection")
            else -> (t.localizedMessage ?: "Something went wrong")
        }
    }

    fun retrieveCars(pageNumber: Int) =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())

            try {
                val response = carsRepository.retrieveCars(pageNumber)
                response.value?.data?.let { emit(Resource.success(it)) }

            } catch (exception: Exception) {

                val handleError = handleError(exception)
                emit(Resource.error(handleError))
            }

        }
}