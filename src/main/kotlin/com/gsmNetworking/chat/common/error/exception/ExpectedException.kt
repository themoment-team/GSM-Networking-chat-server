package com.gsmNetworking.chat.common.error.exception

import org.springframework.http.HttpStatus

open class ExpectedException(
    val status: HttpStatus,
    override val message: String
): RuntimeException(message)