package dev.d1s.security.exception

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class AuthorizationHeaderNotFoundExceptionTest {

    @Test
    fun `should return valid exception message`() {
        expectThat(AuthorizationHeaderNotFoundException.message)
            .isEqualTo("Authorization header is not present.")
    }
}