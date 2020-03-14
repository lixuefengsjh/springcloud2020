package com.atguigu.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;

/**
 * @author: lxf
 * @create: 2020-03-14 19:26
 * @description:
 */
@Component
@Slf4j
public class GateWayFilter implements Ordered, GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String name=exchange.getRequest().getQueryParams().getFirst("name");
        if(StringUtils.isEmpty(name)){
            log.info("-------不匹配------");
            exchange.getResponse().setStatusCode(HttpStatus.BAD_GATEWAY);
            return  exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
