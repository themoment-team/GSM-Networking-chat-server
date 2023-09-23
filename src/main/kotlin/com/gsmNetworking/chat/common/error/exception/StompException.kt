package com.gsmNetworking.chat.common.error.exception

import com.gsmNetworking.chat.common.error.model.ErrorCode

/**
 * GSM Networking 프로젝트에서 사용하는 Exception,
 * STOMP 통신 중인 사용자에게 예외 상황을 알리기 위해 사용합니다.
 */
open class StompException(
    val code: ErrorCode = ErrorCode.DEFAULT,
    override val message: String
): RuntimeException(message)