package dev.d1s.security.exception

import dev.d1s.advice.entity.ErrorResponseData
import dev.d1s.advice.exception.HttpStatusException
import org.springframework.http.HttpStatus

public class AuthenticationException(message: String) : HttpStatusException(
    ErrorResponseData(HttpStatus.UNAUTHORIZED, message)
)