package dev.d1s.security.autoconfiguration

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import dev.d1s.security.aop.SecuredControllerMethodAspect
import dev.d1s.security.service.impl.SimpleAuthorizationServiceImpl

@Configuration
@ConditionalOnProperty("simple-security.enabled")
public class SimpleSecurityAutoConfiguration {

    @Bean
    internal fun securedControllerMethodAspect() = SecuredControllerMethodAspect()

    @Bean
    @ConditionalOnMissingBean
    internal fun simpleAuthorizationService() = SimpleAuthorizationServiceImpl()
}