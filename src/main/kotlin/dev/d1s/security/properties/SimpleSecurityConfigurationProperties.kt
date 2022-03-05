package dev.d1s.security.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Validated
@ConfigurationProperties("simple-security")
internal class SimpleSecurityConfigurationProperties(
    @NotNull var enabled: Boolean,
    @NotBlank var authenticationSecret: String
)