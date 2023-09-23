package com.gsmNetworking.chat.common.socket.processor

import com.gsmNetworking.chat.common.error.exception.StompException
import com.gsmNetworking.chat.common.socket.sender.StompErrorSender
import com.gsmNetworking.chat.common.socket.dto.StompErrorMessage
import org.springframework.stereotype.Component

/**
 * STOMP 에러 처리를 적절한 Sender에게 위임합니다.
 * @see StompErrorSender
 */
@Component
class StompErrorProcessor(
    private val senders: List<StompErrorSender>
) {

    init {
        require(senders.isNotEmpty()) {
            "하나 이상의 StompErrorSender를 등록해야 합니다"
        }
    }

    /**
     * 처리 가능한 Sender에게 STOMP 에러 처리를 위임합니다.
     * @param ex [StompException] 또는 [StompException]의 자식;
     * @see StompErrorSender
     */
    fun sendError(ex: StompException) {
        val supportedSenders = senders.filter { it.supports(ex.javaClass) }

        if (supportedSenders.isEmpty()) {
            throw IllegalStateException("${ex.javaClass}를 처리를 지원하는 senders가 존재하지 않습니다")
        }

        supportedSenders.forEach { sender ->
            sender.send(StompErrorMessage(ex.code, ex.message))
        }
    }
}