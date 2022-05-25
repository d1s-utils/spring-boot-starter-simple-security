package dev.d1s.security.service.impl

import dev.d1s.security.exception.AuthenticationException
import dev.d1s.security.properties.SimpleSecurityConfigurationProperties
import dev.d1s.security.service.SimpleAuthorizationService
import org.springframework.beans.factory.annotation.Autowired

internal class SimpleAuthorizationServiceImpl : SimpleAuthorizationService {

    @Autowired
    private lateinit var simpleSecurityConfigurationProperties: SimpleSecurityConfigurationProperties

    override fun validateAuthentication(credentials: String) {
        if (credentials != simpleSecurityConfigurationProperties.authenticationSecret) {
            throw AuthenticationException("Provided credentials are not valid.")
        }
    }
}