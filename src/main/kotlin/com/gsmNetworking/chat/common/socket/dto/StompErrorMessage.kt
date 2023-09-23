package com.gsmNetworking.chat.common.socket.dto

import com.gsmNetworking.chat.common.error.model.ErrorCode

/**
 * Exception 정보를 STOMP 메시지로 전달하기 위한 객체입니다.
 */
class StompErrorMessage(
    val errorCode: ErrorCode = ErrorCode.DEFAULT,
    val message: String
)