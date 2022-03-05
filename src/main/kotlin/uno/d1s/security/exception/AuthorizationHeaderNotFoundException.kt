package uno.d1s.security.exception

import org.springframework.security.core.AuthenticationException

public object AuthorizationHeaderNotFoundException
    : AuthenticationException("Authorization header is not present.")