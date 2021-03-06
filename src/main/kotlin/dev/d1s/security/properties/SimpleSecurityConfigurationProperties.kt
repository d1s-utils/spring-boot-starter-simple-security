package dev.d1s.security.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotBlank

@Validated
@ConstructorBinding
@ConfigurationProperties("simple-security")
internal data class SimpleSecurityConfigurationProperties(
    val enabled: Boolean = true,

    @NotBlank
    val authenticationSecret: String
)