package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by 携山超 on 2020/5/29
 * 
 * 负载均衡算法的配置类不能放在 @ComponentScan 所扫描的当前包及子包下，
 * 否则我们自定义的这个配置类就会被所有的 Ribbon 客户端所共享，达不到特殊化定制的目的了。
 *
 * 在启动该微服务的时候就能去加载我们的自定义 Ribbon 配置类，并指定服务，从而使配置生效。
 * 例如：@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();  // 定义为随机
    }
}
