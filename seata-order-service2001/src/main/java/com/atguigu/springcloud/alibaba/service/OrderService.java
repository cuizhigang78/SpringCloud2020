package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * create by 携山超 on 2020/6/8
 */
public interface OrderService {
    void create(Order order);
    void update(Long userId, Integer status);
}
