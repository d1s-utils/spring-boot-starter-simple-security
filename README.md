[![](https://jitpack.io/v/d1snin/spring-boot-starter-simple-security.svg)](https://jitpack.io/#d1snin/spring-boot-starter-simple-security)

# spring-boot-starter-simple-security
This starter provides simplest authentication strategy for your server.
Each request is being authenticated using pre-configured secret that should much with the content of `Authorization` request header.
Please note that this is a minimal security, thus, this is not applicable to large-scaled applications.

### Installation
```kotlin
repositories {
    maven(url = "https://jitpack.io")
}

implementation("uno.d1s:spring-boot-starter-simple-security:{spring-boot-starter-simple-security version}")
```

### Example usage
```yaml
# properties
simple-security:
  authentication-secret: "What did you expect?"
```

```kotlin
// controller
@RestController
class SimpleRestController {

    @Secured
    fun sayHello() = "Hello!"
}
```
