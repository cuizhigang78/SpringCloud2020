package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignHystrixService;
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
    String paymentInfo_Timeout(@PathVariable(value = "id") Integer id) {
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("result = " + result);
        return result;
    }
}
