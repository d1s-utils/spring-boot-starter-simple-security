package uno.d1s.security.aop

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.beans.factory.annotation.Autowired
import uno.d1s.security.exception.AuthorizationHeaderNotFoundException
import uno.d1s.security.service.SimpleAuthorizationService
import uno.d1s.teabag.web.currentRequest
import uno.d1s.teabag.web.headers

@Aspect
internal class SecuredControllerMethodAspect {

    private companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    @Autowired
    private lateinit var simpleAuthorizationService: SimpleAuthorizationService

    @Pointcut("@annotation(uno.d1s.security.configuration.annotation.Secured)")
    private fun securedMethodExecution() {
    }

    @Before("securedMethodExecution()")
    fun beforeSecuredMethodExecution() {
        val request = currentRequest

        request.headers[AUTHORIZATION_HEADER]?.let {
            simpleAuthorizationService.validateAuthentication(it)
        } ?: throw AuthorizationHeaderNotFoundException
    }
}