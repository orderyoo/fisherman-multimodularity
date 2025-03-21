package com.example.data.network

import org.json.JSONObject
import retrofit2.Response

private const val RESPONSE_MESSAGE = "message"

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Result<T> {
    return runCatching {
        val response = call.invoke()

        if (response.isSuccessful) {
            response.body() ?: throw IllegalStateException("Response body is null")
        } else {
            val errorMessage = response.errorBody()?.string()?.let { errorBody ->
                runCatching {
                    JSONObject(errorBody).getString(RESPONSE_MESSAGE)
                }.getOrNull() ?: "Unknown error"
            }
            throw HttpException(response.code(), errorMessage)
        }
    }
}