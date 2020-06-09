package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * create by 携山超 on 2020/6/8
 */
@Mapper
public interface OrderDao {
    /**
     * 新建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态 0 -> 1
     * @param userId 用户id
     * @param status 订单状态
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
