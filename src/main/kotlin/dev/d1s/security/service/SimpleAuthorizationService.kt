package dev.d1s.security.service

public interface SimpleAuthorizationService {

    public fun validateAuthentication(credentials: String)
}