package com.gsmNetworking.chat.common.socket.sender

import com.gsmNetworking.chat.common.error.exception.StompException
import com.gsmNetworking.chat.common.socket.dto.StompErrorMessage

/**
 * Stomp 에러 메시지를 전송하는 역할의 객체입니다.
 */
interface StompErrorSender {
    /**
     * Stomp 에러 메시지를 전송합니다.
     *
     * @param message 전송할 에러 메시지
     */
    fun send(message: StompErrorMessage)

    /**
     * 특정 Exception Class 지원 여부를 확인합니다.
     *
     * @param clazz 지원 여부를 확인할 [StompException] 또는 [StompException]의 자식 클래스
     * @return 지원한다면 True, 지원하지 않으면 False를 반환
     * @see StompException
     */
    fun supports(clazz: Class<out StompException>): Boolean
}