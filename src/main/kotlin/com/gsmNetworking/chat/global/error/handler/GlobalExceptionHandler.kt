package com.gsmNetworking.chat.global.error.handler

import com.gsmNetworking.chat.global.error.exception.ExpectedException
import com.gsmNetworking.chat.global.error.model.ExceptionResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

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

}