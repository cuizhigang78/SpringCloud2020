package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * create by 携山超 on 2020/5/26
 *
 * 1. 先启动 eureka 注册中心
 * 2. 启动服务提供者 payment 支付服务
 * 3. payment 启动后会把自身信息（比如服务地址以别名方式注册进 eureka)
 * 4. 消费者 order 服务在需要调用接口时，使用服务别名去注册中心获取实际的 RPC 远程调用地址
 * 5. 消费者获得调用地址的，底层实际是利用 HttpClient 技术实现远程调用
 * 6. 消费者获取服务地址后会缓存在本地 JVM 内存中，默认每隔 30s 更新一次服务调用地址
 *
 * Eureka 自我保护机制
 *
 * 1. 为什么会产生自我保护机制？
 *
 *      为了保证 EurekaClient 可以正常运行，但是与 EurekaServer 网络不通的情况下，EurekaServer 不会立即将 EurekaClient 剔除
 *
 * 2. 什么是自我保护机制
 *
 *     默认情况下，如果 EurekaServer 在一定时间内（默认90秒）没有接到某个微服务实例的心跳，EurekaServer 将会注销该实例。但是当
 * 网络分区故障发生（如延时、卡顿、拥挤）时，微服务与 EurekaServer 之间无法正常通信，以上行为可能变得非常危险了——因为微服务本身是
 * 健康的，此时本不应该注销这个服务。Eureak 通过“自我保护模式”来解决这个问题——当 EurekaServer 节点在短时间内丢失过多客户端时（可
 * 能发生了网络分区故障），那么这个节点就会进入自我保护模式。
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
