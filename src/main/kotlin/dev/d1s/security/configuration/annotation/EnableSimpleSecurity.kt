package dev.d1s.security.configuration.annotation

import dev.d1s.security.autoconfiguration.ConfigurationPropertiesAutoConfiguration
import dev.d1s.security.autoconfiguration.SimpleSecurityAutoConfiguration
import dev.d1s.security.autoconfiguration.WebSecurityAutoConfiguration
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(
    SimpleSecurityAutoConfiguration::class,
    ConfigurationPropertiesAutoConfiguration::class,
    WebSecurityAutoConfiguration::class
)
public annotation class EnableSimpleSecurity
