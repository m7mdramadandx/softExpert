package com.example.myapplication.model

data class Resource(
    val statusResponse: StatusResponse,
    val data: MutableList<CarModel>? = null,
    val message: String? = null
) {

    companion object {
        fun loading(): Resource = Resource(StatusResponse.LOADING)

        fun success(data: MutableList<CarModel>): Resource = Resource(StatusResponse.SUCCESS, data)

        fun error(message: String): Resource =
            Resource(statusResponse = StatusResponse.ERROR, message = message)
    }

}