package uno.d1s.security.configuration.annotation

import org.springframework.context.annotation.Import
import uno.d1s.security.autoconfiguration.ConfigurationPropertiesAutoConfiguration
import uno.d1s.security.autoconfiguration.SimpleSecurityAutoConfiguration

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(SimpleSecurityAutoConfiguration::class, ConfigurationPropertiesAutoConfiguration::class)
public annotation class EnableSimpleSecurity
