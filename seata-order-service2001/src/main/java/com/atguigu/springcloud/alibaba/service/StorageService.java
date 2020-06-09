package com.atguigu.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by 携山超 on 2020/6/8
 */
@Component
@FeignClient(value = "SEATA-STORAGE-SERVICE")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    void decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
