package com.gsmNetworking.chat.global.exception.handler

import com.gsmNetworking.chat.domain.user.exception.UserStompException
import org.slf4j.LoggerFactory
import org.springframework.messaging.Message
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.StompSubProtocolErrorHandler


/**
 * Socket 통신 전/후에 발생하는 에러를 처리하는 handler 입니다.
 */
@Component
class CustomStompSubProtocolErrorHandler : StompSubProtocolErrorHandler() {
    private val log = LoggerFactory.getLogger(this.javaClass)!! //TODO 로깅 구현 통일하기
    override fun handleClientMessageProcessingError(
        clientMessage: Message<ByteArray>?,
        ex: Throwable
    ): Message<ByteArray>? {
        when (val cause = ex.cause) {
            is UserStompException -> {
                TODO("add handling ex")
            }

            is Exception -> {
                log.error("An error occurred", ex)
            }
        }

        return super.handleClientMessageProcessingError(clientMessage, ex)
    }
}