package com.cleanarch.base.entity.result.api

import com.cleanarch.base.common.ApiExtraInfo
import com.cleanarch.base.entity.result.IResultEntity

sealed class APIResultEntity<out R> : IResultEntity {
    data class Success<out T>(val data: T) : APIResultEntity<T>()
    sealed class Failure : APIResultEntity<Nothing>() {
        data class ErrorException(val exceptionError: Exception, val apiExtraInfo: ApiExtraInfo?) : Failure()
        data class ErrorFailure(
            val httpCode: Int,
            val responseMessage: String,
            val responseErrorBody: String?,
            val apiExtraInfo: ApiExtraInfo?,
            val tmsErrorCode: String? = null
        ) : Failure()
    }
}
