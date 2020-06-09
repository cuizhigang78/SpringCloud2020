package com.atguigu.springcloud.controlle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by 携山超 on 2020/6/6
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable(value = "id") Integer id) {
        return "nacoa registry, serverPort: " + serverPort + "\t id: " + id;
    }
}
