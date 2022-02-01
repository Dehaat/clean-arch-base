package com.cleanarch.base.data.api

import com.cleanarch.base.data.IData
import okhttp3.ResponseBody

data class DataResponseUnsuccessful(
    val errorCode: Int,
    val errorBody: ResponseBody?,
    val errorMsgResponse: String,
): IData