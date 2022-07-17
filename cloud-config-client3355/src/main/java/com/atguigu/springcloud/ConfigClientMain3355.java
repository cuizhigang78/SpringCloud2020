package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * create by 携山超 on 2020/6/2
 *
 * 什么是总线？
 *
 * 在微服务架构的系统中，通常会使用轻量级的消息代理来构建一个共用的消息主题，并让系统中所有的微服务实例都连接上来。
 * 由于该主题中产生的消息会被所有实例监听和消费，所以称它为消息总线。在总线上的各个实例，都可以方便地广播一些需要
 * 让其他连接在该主题上的实例都知道的消息。
 *
 * 基本原理
 *
 * ConfigClient 实例都监听 MQ 中同一个 topic(默认是 springCloudBus)。当一个服务刷新数据的时候，它会把这个信息
 * 放到 topic 中，这样其他监听这个 topic 的服务就能得到通知，然后去更新自身的配置。
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class, args);
    }
}
