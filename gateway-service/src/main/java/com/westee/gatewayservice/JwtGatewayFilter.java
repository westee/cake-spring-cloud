package com.westee.gatewayservice;

import com.westee.common.utils.JWTUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String jwt = headers.getFirst("Authorization"); // 假设令牌放在Authorization头中，格式为Bearer <token>

        if (jwt != null && jwt.startsWith("Bearer ") && jwt.length() > 7) { // 确保请求中包含正确的令牌格式和内容
            try {
                // 这里是令牌验证逻辑，通常会与你的JWT验证服务交互。这里只是简单示例。
                String tokenContent = jwt.substring(7); // 获取令牌内容
                // 这里使用一个简单的字符串匹配来验证令牌内容，实际应用中需要与JWT验证服务交互。
                JWTUtil.verify(tokenContent);

                return chain.filter(exchange); // 如果验证通过，继续处理请求。否则抛出异常或返回特定的响应。

            } catch (Exception e) { // 处理令牌解析错误等异常情况。
                exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                return exchange.getResponse().writeWith(Mono.just(
                        exchange.getResponse().bufferFactory().wrap("Unauthorized".getBytes())));
            }
        } else { // 如果请求中没有令牌或令牌格式不正确，返回401未授权状态码。你可以自定义你的错误处理方式。
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().writeWith(Mono.just(
                    exchange.getResponse().bufferFactory().wrap("Unauthorized".getBytes())));
        }
    }


    @Override
    public int getOrder() {
        return -1;
    } // 确保过滤器在所有路由处理之前执行。你可以根据需要调整顺序。返回负数将使过滤器在所有路由处理之前执行。返回正数将使过滤器在所有路由处理之后执行
}
