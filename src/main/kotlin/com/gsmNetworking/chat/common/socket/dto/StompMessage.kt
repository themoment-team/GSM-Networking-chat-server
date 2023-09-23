package com.gsmNetworking.chat.common.socket.dto

/**
 * STOMP 메시지를 사용자에게 전달하기 위한 Wrapper 객체입니다.
 */
class StompMessage<T>(
    val content: T
)