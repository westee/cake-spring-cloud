```yaml
server:
  port: 9201
service-url:
  user-service: http://localhost:8080

spring:
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
          lower-case-service-id: true
      routes:
        - id: status
          uri: ${service-url.user-service}/api/v1/status
          predicates:
          - Path=/api/v1/status
        - id: role
          uri: ${service-url.user-service}/api/v1/role
          predicates:
          - Path=/api/v1/role

  application:
    name: gateway-service

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8001/eureka/
```
当匹配到`predicates`中的选项时，会路由到routes中predicates对应的uri。
当访问`http://localhost:9201/api/v1/status` 时会根据routes匹配路由到 `http://localhost:8080/api/v1/status` 。
匹配成功后执行`JwtGatewayFilter`中的逻辑，检查token的合法性。