package dev.d1s.security.controller.advice

import dev.d1s.security.exception.AuthenticationException
import dev.d1s.teabag.testing.constant.VALID_STUB
import dev.d1s.teabag.testing.mockResponse
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [ExceptionHandlerControllerAdvice::class])
internal class ExceptionHandlerControllerAdviceTest {

    @Autowired
    private lateinit var exceptionHandlerControllerAdvice: ExceptionHandlerControllerAdvice

    @Test
    fun `should handle AuthenticationException`() {
        val response = spyk(mockResponse)

        assertDoesNotThrow {
            exceptionHandlerControllerAdvice.handleAuthenticationException(
                AuthenticationException(VALID_STUB),
                response
            )
        }

        verify {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), VALID_STUB)
        }
    }
}