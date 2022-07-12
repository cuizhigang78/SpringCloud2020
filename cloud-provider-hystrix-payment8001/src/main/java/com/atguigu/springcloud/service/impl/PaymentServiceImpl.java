package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * create by 携山超 on 2020/5/30
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程名称：" + Thread.currentThread().getName() + " paymentInfo_OK, id:" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String paymentInfo_Timeout(Integer id) {
        long millis = 2000L;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程名称：" + Thread.currentThread().getName() + " paymentInfo_Timeout, id:" + id + " 用时：" + millis + "ms O(∩_∩)O哈哈~";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程名称：" + Thread.currentThread().getName() + " 系统超时或程序运行异常, o(╥﹏╥)o";
    }

    /**
     * 服务熔断
     *
     * 涉及到断路器的三个重要参数：快照时间窗、请求总数阈值和错误百分比阈值
     *
     * 1. 快照时间窗：断路器确定是否打开需要统计一段时间内的所有请求，这个时间范围就是快照时间窗，默认为最近10s
     * 2. 请求总数阈值：在快照时间窗内，必须满足请求总数阈值才会触发熔断，默认为20次，即在10s内，收到的请求数达到20，才可能触发熔断
     * 3. 错误百分比阈值：当请求总数在快照时间窗内超过了请求总数阈值，并且出现错误的次数超过错误百分比阈值，这时就会触发熔断
     *
     * 当熔断器开启时，所有的请求都不会进行转发。一段时间后（默认5秒），熔断器进入半开（half open）状态，会让其中一个请求进行转发，
     * 如果成功，断路器会关闭，否则，继续保持开启，并重复这一流程。
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数超过10
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间范围 ms
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 失败率超过60%
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("*** id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }
}
