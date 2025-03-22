package group.practices.java.apigateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * description: Describe the feature.
 * date: 2025/3/20
 *
 * @author Al Elijah
 */
@Component
public class GlobalFilter implements org.springframework.cloud.gateway.filter.GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("请求到达网关");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
