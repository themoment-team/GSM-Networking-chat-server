package com.gsmNetworking.chat.domain.user.exception

import com.gsmNetworking.chat.common.error.exception.StompException
import com.gsmNetworking.chat.common.error.model.ErrorCode

/**
 * [StompException]의 구현체, User 도메인에서 발생한 예외에 대한 설명을 Client에게 전달하기 위해 사용합니다.
 *
 * @param code
 * @param message
 */
class UserStompException(
    code: ErrorCode = ErrorCode.DEFAULT,
    message: String
) : StompException(code, message) {
}