package com.gsmNetworking.chat.domain.chat.sender

import com.gsmNetworking.chat.common.error.exception.StompException
import com.gsmNetworking.chat.common.socket.dto.StompErrorMessage
import com.gsmNetworking.chat.common.socket.sender.StompErrorSender
import com.gsmNetworking.chat.domain.chat.exception.ChatStompException
import org.springframework.stereotype.Component

/**
 * [StompErrorSender]의 구현체, Char 도메인의 Stomp 에러 메시지를 처리합니다.
 */
@Component
class CharErrorSender : StompErrorSender {
    /**
     * Stomp 에러 메시지를 전송하는 메서드입니다.
     *
     * @param message 전송할 에러 메시지
     */
    override fun send(message: StompErrorMessage) {
        TODO("Not yet implemented")
    }

    /**
     * 특정 [StompException] Class 또는 해당 클래스의 하위 클래스를 지원하는지 확인합니다.
     *
     * @param clazz 지원 여부를 확인할 [StompException] 또는 [StompException]의 자식 클래스
     * @return 지원한다면 True, 지원하지 않으면 False를 반환
     */
    override fun supports(clazz: Class<out StompException>): Boolean {
        return ChatStompException::class.java.isAssignableFrom(clazz)
    }
}
