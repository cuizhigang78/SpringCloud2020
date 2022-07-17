package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName StreamMQMain8801
 * @Author cuizhigang
 * @Date 2020/9/1 16:25
 * @Description StreamMQMain8801
 * @Version 1.0
 *
 * 什么是 Spring Cloud Stream ？
 *
 * 官方定义 Spring Cloud Stream 是一个构建消息驱动微服务的框架。
 *
 * 应用程序通过 inputs 或者 outputs 来与 Spring Cloud Stream 中的 binder 对象交互。通过配置来 binding（绑定），而 Spring Cloud Stream
 * 的 binder 对象负责与消息中间件交互。所以，我们只需要搞清楚如何与 Spring Cloud Stream 交互就可以方便地使用消息驱动的方式。
 *
 * 通过使用 Spring Integration 来连接消息代理中间件以实现消息事件驱动。Spring Cloud Stream 为一些供应商的消息中间件产品提供了个性化的自动化配置实现，引用了发布-订阅、消费组、
 * 分区的三个核心概念。
 *
 * 目前仅支持 RabbitMQ、Kafka
 */
@SpringBootApplication
public class StreamMQMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8801.class, args);
    }
}
