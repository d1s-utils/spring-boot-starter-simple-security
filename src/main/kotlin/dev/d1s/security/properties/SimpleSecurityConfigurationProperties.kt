package dev.d1s.security.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotBlank

@Validated
@ConfigurationProperties("simple-security")
internal class SimpleSecurityConfigurationProperties(
    var enabled: Boolean = true,
    @NotBlank var authenticationSecret: String? = null
)