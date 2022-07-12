package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * create by 携山超 on 2020/5/25
 *
 * Feign 旨在使编写 Java Http 客户端变得容易
 *
 * 前面在使用 Ribbon + RestTemplate 时，利用 RestTemplate 对 http 请求的封闭处理，形成一套模板化的调用方法。
 * 但是在实际开发中，由于对服务依赖的调用可能不止一处，往往一个接口会被多处调用，所以通常都会针对每个微服务自行封
 * 装一些客户端类来包装这些依赖服务的调用。所以，Feign 在此基础上做了进一步封装。
 *
 * 在 Feign 的实现下，我们只需要创建一个接口并使用注解的方式来配置它（以前是 Dao 接口上面标注 Mapper 注解，现在是
 * 一个微服务接口上面标注一个 Feign 注解），即可完成对服务提供方的接口绑定，简化了使用 Ribbon 时的开发量。
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
