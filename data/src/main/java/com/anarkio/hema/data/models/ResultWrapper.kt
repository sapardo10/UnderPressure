package com.anarkio.hema.data.models

import com.anarkio.hema.data.utils.ErrorCode

sealed class ResultWrapper<out T> {
    data class Success<out R>(val value: R): ResultWrapper<R>()
    data class Failure(
        val errorCode: ErrorCode,
        val throwable: Throwable?
    ): ResultWrapper<Nothing>()
}