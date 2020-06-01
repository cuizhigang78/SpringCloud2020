package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * create by 携山超 on 2020/5/25
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderController {

    @Resource
    private PaymentFeignHystrixService paymentService;

    /**
     * 正常返回
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable(value = "id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("result = " + result);
        return result;
    }

    /**
     * 异常返回：超时
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    String paymentInfo_Timeout(@PathVariable(value = "id") Integer id) {
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("result = " + result);
        return result;
    }
    String paymentTimeOutFallbackMethod(@PathVariable(value = "id") Integer id) {
        return "我是消费者80，对方支付系统繁忙，请10秒后重试或者自己运行出错请检查自己，o(╥﹏╥)o";
    }

    /**
     * 全局异常处理信息
     * @return
     */
    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息，请稍后再试，o(╥﹏╥)o";
    }
}
