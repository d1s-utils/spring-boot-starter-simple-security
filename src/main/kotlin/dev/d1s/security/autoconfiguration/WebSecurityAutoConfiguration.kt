package dev.d1s.security.autoconfiguration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
public class WebSecurityAutoConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        // not using spring security for requests authorization
        http.authorizeRequests().anyRequest().permitAll()
    }
}