goods-service模块使用了openfeign模块，所以在goods-service的启动类加上`@EnableFeignClients`。

这个注解的作用主要有两个：

1. 启用 Feign 的功能，让 Spring Cloud 可以识别并使用 Feign 客户端。
2. 指定需要扫描的包路径，让 Spring Cloud 知道在哪里查找 Feign 客户端接口。