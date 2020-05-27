package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * create by 携山超 on 2020/5/24
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
