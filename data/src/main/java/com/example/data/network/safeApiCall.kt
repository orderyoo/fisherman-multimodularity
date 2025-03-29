package com.example.data.network

import retrofit2.Response
import retrofit2.HttpException
import java.io.IOException

class NetworkException(val code: Int, override val message: String?): Exception(message)

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Result<T> {
    return try {
        val response = call()

        if (response.isSuccessful) {
            response.body()?.let { body ->
                Result.success(body)
            } ?: Result.failure(NullPointerException("Response body is null"))
        } else {
            val errorMsg = response.errorBody()?.string() ?: "Unknown error"
            Result.failure(NetworkException(response.code(), errorMsg))
        }
    } catch (e: IOException) {
        Result.failure(IOException("Network error: ${e.message}", e))
    } catch (e: HttpException) {
        Result.failure(e)
    } catch (e: Exception) {
        Result.failure(IllegalStateException("Unexpected error", e))
    }
}