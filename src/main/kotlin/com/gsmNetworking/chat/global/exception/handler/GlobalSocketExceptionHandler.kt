package com.gsmNetworking.chat.global.exception.handler

import com.gsmNetworking.chat.domain.user.exception.UserStompException
import org.slf4j.LoggerFactory
import org.springframework.messaging.handler.annotation.MessageExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalSocketExceptionHandler {
    private val log = LoggerFactory.getLogger(this.javaClass)!! //TODO 로깅 구현 통일하기

    /**
     * [UserStompException] 혹은 해당 클래스의 자식을 핸들링하는 메서드 입니다.
     *
     * @param e [UserStompException] 혹은 [UserStompException]을 상속하는 클래스
     */
    @MessageExceptionHandler(UserStompException::class)
    fun handler(e: UserStompException): Unit = TODO("send error to client")


    /**
     * 예외처리하지 않은 [RuntimeException] 포함한 하위 에러를 핸들링합니다.
     *
     * @param e [RuntimeException]또는 [RuntimeException]을 상속하는 객체
     */
    @MessageExceptionHandler(Exception::class)
    fun handler(e: Exception): Unit = log.error("Uncatched Exception", e)

}