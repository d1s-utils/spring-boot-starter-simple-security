package uno.d1s.security.service

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.test.context.ContextConfiguration
import uno.d1s.security.properties.SimpleSecurityConfigurationProperties
import uno.d1s.security.service.impl.SimpleAuthorizationServiceImpl
import uno.d1s.teabag.testing.constant.INVALID_STUB
import uno.d1s.teabag.testing.constant.VALID_STUB

@SpringBootTest
@ContextConfiguration(classes = [SimpleAuthorizationServiceImpl::class])
class SimpleAuthorizationServiceImplTest {

    @Autowired
    private lateinit var simpleAuthorizationServiceImpl: SimpleAuthorizationServiceImpl

    @MockkBean
    private lateinit var simpleSecurityConfigurationProperties: SimpleSecurityConfigurationProperties

    @BeforeEach
    fun setup() {
        every {
            simpleSecurityConfigurationProperties.authenticationSecret
        } returns VALID_STUB
    }

    @Test
    fun `should not throw any exception`() {
        assertDoesNotThrow {
            simpleAuthorizationServiceImpl.validateAuthentication(VALID_STUB)
        }

        this.verifyAuthenticationSecretCall()
    }

    @Test
    fun `should throw BadCredentialsException`() {
        assertThrows<BadCredentialsException> {
            simpleAuthorizationServiceImpl.validateAuthentication(INVALID_STUB)
        }

        this.verifyAuthenticationSecretCall()
    }

    private fun verifyAuthenticationSecretCall() {
        verify {
            simpleSecurityConfigurationProperties.authenticationSecret
        }
    }
}