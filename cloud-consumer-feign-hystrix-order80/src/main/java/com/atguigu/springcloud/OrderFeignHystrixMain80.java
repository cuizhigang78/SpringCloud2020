package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * create by 携山超 on 2020/5/25
 *
 * Hystrix 是一个用于处理分布式系统的延迟和容错的开源库，在分布式系统里，许多依赖不可避免的会调用失败，比如超时，
 * 异常等，Hystrix 能够保证在一个依赖出问题的情况下，不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性。
 *
 * ”断路器“本身是一种开头装置，当某个服务单元发生故障后，通过断路器的故障监控（类似熔断保险丝），向调用方返回一个
 * 符合预期的、可处理的备选响应（FallBack），而不是长时间地等待或者抛出调用方无法处理的异常。这样就保证了服务调用
 * 方的线程不会被长时间、不必要地占用，从而避免了故障在分布式系统中的蔓延，乃至雪崩。
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderFeignHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixMain80.class, args);
    }
}
