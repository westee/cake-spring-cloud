```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```
OpenFeign是一个声明式的HTTP客户端，可以简化微服务之间的调用。
像`openfeign.xxx()`来调用指定接口。

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
Eureka Client是微服务应用程序，通过向Eureka Server注册自己的实例信息，以便其他服务能够发现并调用它。