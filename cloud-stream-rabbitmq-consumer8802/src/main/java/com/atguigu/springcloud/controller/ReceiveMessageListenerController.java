package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * @ClassName ReceiveMessageListenerController
 * @Author cuizhigang
 * @Date 2020/9/1 19:22
 * @Description ReceiveMessageListenerController
 * @Version 1.0
 */
@Controller
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message) {
        System.out.println("消费者：" + port + "接收到消息" + message.getPayload());
    }
}
