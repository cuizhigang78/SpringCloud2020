package com.atguigu.springcloud.service.impl;

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
        Long millis = 5000L;
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
}
