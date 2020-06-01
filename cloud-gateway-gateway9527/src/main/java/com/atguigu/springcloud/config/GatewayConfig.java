package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by 携山超 on 2020/6/1
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocatorGuonei(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu_guonei", r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocatorGuoji(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu_guoji", r -> r.path("/guoji").uri("https://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
