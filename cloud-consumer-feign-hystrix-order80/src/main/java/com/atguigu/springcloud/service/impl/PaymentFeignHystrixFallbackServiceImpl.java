package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentFeignHystrixService;
import org.springframework.stereotype.Component;

/**
 * create by 携山超 on 2020/5/31
 */
@Component
public class PaymentFeignHystrixFallbackServiceImpl implements PaymentFeignHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFeignHystrixFallbackServiceImpl paymentInfo_OK fallback，o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentFeignHystrixFallbackServiceImpl paymentInfo_Timeout fallback，o(╥﹏╥)o";
    }
}
