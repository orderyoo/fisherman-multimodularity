package com.example.data.network

class HttpException(val code: Int, override val message: String?): Exception(message)