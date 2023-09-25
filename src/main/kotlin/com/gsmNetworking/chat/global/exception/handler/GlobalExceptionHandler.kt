package com.gsmNetworking.chat.global.exception.handler

import com.gsmNetworking.chat.common.error.exception.ExpectedException
import com.gsmNetworking.chat.common.error.model.ExceptionResponse
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    private val log = LoggerFactory.getLogger(this.javaClass)!! //TODO 로깅 구현 통일하기

    /**
     * ExpectedException과 ExpectedException을 상속받은 예외 클래스를 핸들해는 메서드 입니다.
     *
     * @param e {ExpectedException 혹은 ExpectedException을 상속하는 클래스}
     * @return ExceptionResponse
     */
    @ExceptionHandler(ExpectedException::class)
    fun handler(e: ExpectedException): ResponseEntity<ExceptionResponse> =
        ResponseEntity
            .status(e.status)
            .body(ExceptionResponse(message = e.message))


    /**
     * 예외처리하지 않은 [RuntimeException] 포함한 하위 에러를 핸들링합니다.
     *
     * @param e [RuntimeException]또는 [RuntimeException]을 상속하는 객체
     */
    @ExceptionHandler(Exception::class)
    fun handler(e: Exception): Unit = log.error("Uncatched Exception", e)
}