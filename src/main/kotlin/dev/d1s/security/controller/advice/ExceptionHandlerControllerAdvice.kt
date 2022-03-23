package dev.d1s.security.controller.advice

import dev.d1s.security.exception.AuthenticationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
internal class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(AuthenticationException::class)
    fun handleAuthenticationException(exception: AuthenticationException, response: HttpServletResponse) {
        response.sendError(HttpStatus.UNAUTHORIZED.value(), exception.message)
    }
}