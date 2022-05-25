package dev.d1s.security.autoconfiguration

import dev.d1s.security.service.impl.SimpleAuthorizationServiceImpl
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty("simple-security.enabled", matchIfMissing = true)
public class SimpleSecurityAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    internal fun simpleAuthorizationService() =
        SimpleAuthorizationServiceImpl()
}