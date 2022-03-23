package dev.d1s.security.autoconfiguration

import dev.d1s.security.aop.SecuredControllerMethodAspect
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

@Configuration
@EnableAspectJAutoProxy
public class AopAutoConfiguration {

    @Bean
    internal fun securedControllerMethodAspect() = SecuredControllerMethodAspect()
}