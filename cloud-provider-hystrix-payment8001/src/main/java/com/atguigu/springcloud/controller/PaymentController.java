package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * create by 携山超 on 2020/5/30
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    /**
     * 正常返回
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable(value = "id") Integer id) {
        log.info("id = " + id);
        return paymentService.paymentInfo_OK(id);
    }

    /**
     * 异常返回：超时
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable(value = "id") Integer id) {
        log.info("id = " + id);
        return paymentService.paymentInfo_Timeout(id);
    }

    // ==== 服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("**** result: " + result);
        return result;
    }
}
