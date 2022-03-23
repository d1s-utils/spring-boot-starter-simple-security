package dev.d1s.security.autoconfiguration

import dev.d1s.security.aop.SecuredControllerMethodAspect
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

@Configuration
@EnableAspectJAutoProxy
@ConditionalOnProperty("simple-security.enabled")
public class AopAutoConfiguration {

    @Bean
    internal fun securedControllerMethodAspect() = SecuredControllerMethodAspect()
}