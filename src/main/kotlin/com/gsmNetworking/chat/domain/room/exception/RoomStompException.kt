package com.gsmNetworking.chat.domain.room.exception

import com.gsmNetworking.chat.common.error.exception.StompException
import com.gsmNetworking.chat.common.error.model.ErrorCode
import java.util.UUID

/**
 * [StompException]의 구현체, Room 도메인에서 발생한 예외에 대한 설명을 Client에게 전달하기 위해 사용합니다.
 *
 * @param code
 * @param message
 */
class RoomStompException(
    code: ErrorCode = ErrorCode.DEFAULT,
    message: String,
    val userId: Long
) : StompException(code, message) {
}