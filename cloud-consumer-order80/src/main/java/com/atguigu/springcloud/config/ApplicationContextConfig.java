package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * create by 携山超 on 2020/5/25
 */
@Configuration
public class ApplicationContextConfig {
    /**
     * Ribbon 本地负载均衡，在调用微服务接口的时候，会在注册中心上获取注册信息服务列表之后缓存到 JVM本地，
     * 从而在本地实现 RPC 远程服务调用技术。
     *
     *
     * Ribbon 在工作时分为两步：
     *
     * 1. 先选择 Eureka Server，它优先选择在同一个区域内负载较少的 server
     * 2. 再根据用户指定的策略，从 server 取到的服务注册列表中选择一个地址
     *
     * Ribbon 提供了多种策略：如轮询、随机和根据响应时间加权
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
