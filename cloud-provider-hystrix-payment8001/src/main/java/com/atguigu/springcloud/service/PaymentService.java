package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * create by 携山超 on 2020/5/30
 */
public interface PaymentService {
    /**
     * 正常返回
     * @param id
     * @return
     */
    String paymentInfo_OK(Integer id);

    /**
     * 异常返回：超时
     * @param id
     * @return
     */
    String paymentInfo_Timeout(Integer id);

    /**
     * 服务熔断
     * @param id
     * @return
     */
    String paymentCircuitBreaker(Integer id);
}
