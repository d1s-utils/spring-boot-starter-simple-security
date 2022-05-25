package dev.d1s.security.aop

import com.ninjasquad.springmockk.MockkBean
import dev.d1s.security.exception.AuthenticationException
import dev.d1s.security.service.SimpleAuthorizationService
import dev.d1s.teabag.testing.constant.INVALID_STUB
import dev.d1s.teabag.testing.constant.VALID_STUB
import dev.d1s.teabag.testing.spring.web.http.mockRequest
import dev.d1s.teabag.web.currentRequest
import dev.d1s.teabag.web.headers
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [SecuredControllerMethodAspect::class])
internal class SecuredControllerMethodAspectTest {

    private companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    @Autowired
    private lateinit var securedControllerMethodAspect: SecuredControllerMethodAspect

    @MockkBean(relaxUnitFun = true)
    private lateinit var simpleAuthorizationService: SimpleAuthorizationService

    @BeforeEach
    fun setup() {
        every {
            simpleAuthorizationService.validateAuthentication(INVALID_STUB)
        } throws AuthenticationException(VALID_STUB)
    }

    @Test
    fun `should not throw any exception`() {
        mockCurrentRequestAndHeaders {
            every {
                currentRequest.headers[AUTHORIZATION_HEADER]
            } returns VALID_STUB

            assertDoesNotThrow {
                securedControllerMethodAspect.beforeSecuredMethodExecution()
            }

            verify {
                currentRequest.headers[AUTHORIZATION_HEADER]
            }

            verify {
                simpleAuthorizationService.validateAuthentication(VALID_STUB)
            }
        }
    }

    @Test
    fun `should throw AuthenticationException`() {
        mockCurrentRequestAndHeaders {
            every {
                currentRequest.headers[AUTHORIZATION_HEADER]
            } returns null

            assertThrows<AuthenticationException> {
                securedControllerMethodAspect.beforeSecuredMethodExecution()
            }

            verify {
                currentRequest.headers[AUTHORIZATION_HEADER]
            }
        }
    }

    private inline fun mockCurrentRequestAndHeaders(block: () -> Unit) {
        mockkStatic("dev.d1s.teabag.web.CurrentRequestKt") {
            mockkStatic("dev.d1s.teabag.web.HttpServletRequestExtKt") {
                every {
                    currentRequest
                } returns mockRequest

                block()
            }
        }
    }
}
