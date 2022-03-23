package dev.d1s.security.configuration.annotation

import dev.d1s.security.autoconfiguration.ConfigurationPropertiesAutoConfiguration
import dev.d1s.security.autoconfiguration.SimpleSecurityAutoConfiguration
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(
    SimpleSecurityAutoConfiguration::class,
    ConfigurationPropertiesAutoConfiguration::class
)
public annotation class EnableSimpleSecurity
