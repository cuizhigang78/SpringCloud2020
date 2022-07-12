package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 三大核心概念：
 *
 * 1. Route（路由）：路由是构建网关的基本模块，它由 ID，目标 URI，一系列的断言和过滤器组成，如果断言为 true 则匹配该路由。
 * 2. Predicate（断言）：参考的是 Java8 java.util.function.Predicate 开发人员可以匹配 HTTP 请求中的所有内容（例如请求头或请求参数），如果请求与断言相匹配则进行路由。
 * 3. Filter（过滤）： GatewayFilter的实例，使用过滤器，可以在请求路由前或后对请求进行修改。
 *
 * create by 携山超 on 2020/5/31
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }
}
