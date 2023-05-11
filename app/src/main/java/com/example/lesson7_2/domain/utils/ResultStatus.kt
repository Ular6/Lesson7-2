package com.example.lesson7_2.domain.utils

sealed class ResultStatus<T> {

    class Loading<T> : ResultStatus<T>()
    class Success<T>(data: T?) : ResultStatus<T>()
    class Error<T>(message: String) : ResultStatus<T>()
}