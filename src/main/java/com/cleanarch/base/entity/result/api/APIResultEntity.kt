package com.cleanarch.base.entity.result.api

import com.cleanarch.base.common.ApiExtraInfo
import com.cleanarch.base.entity.result.IResultEntity

sealed class APIResultEntity<out R>(val apiTraceId: String?) : IResultEntity {
    class Success<out T>(val data: T, apiTraceId: String? = "") : APIResultEntity<T>(apiTraceId)
    sealed class Failure(apiTraceId: String?) : APIResultEntity<Nothing>(apiTraceId) {
        class ErrorException(val exceptionError: Exception, val apiExtraInfo: ApiExtraInfo?) :
            Failure(apiExtraInfo?.get("IB-Request-Identifier"))

        class ErrorFailure(
            val httpCode: Int,
            val responseMessage: String,
            val responseErrorBody: String?,
            val apiExtraInfo: ApiExtraInfo?,
            val tmsErrorCode: String? = null
        ) : Failure(apiExtraInfo?.get("IB-Request-Identifier"))
    }
}
