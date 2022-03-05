package dev.d1s.security.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.BadCredentialsException
import dev.d1s.security.properties.SimpleSecurityConfigurationProperties
import dev.d1s.security.service.SimpleAuthorizationService

internal class SimpleAuthorizationServiceImpl : SimpleAuthorizationService {

    @Autowired
    private lateinit var simpleSecurityConfigurationProperties: SimpleSecurityConfigurationProperties

    override fun validateAuthentication(credentials: String) {
        if (credentials != simpleSecurityConfigurationProperties.authenticationSecret) {
            throw BadCredentialsException("Provided credentials are not valid.")
        }
    }
}