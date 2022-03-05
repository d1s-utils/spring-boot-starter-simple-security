package uno.d1s.security

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootStarterSimpleSecurityApplication

fun main(args: Array<String>) {
    runApplication<SpringBootStarterSimpleSecurityApplication>(*args)
}
