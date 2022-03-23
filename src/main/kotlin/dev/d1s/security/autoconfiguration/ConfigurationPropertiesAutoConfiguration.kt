package dev.d1s.security.autoconfiguration

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(basePackages = ["dev.d1s.security.properties"])
public class ConfigurationPropertiesAutoConfiguration