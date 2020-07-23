package com.hxq.springcloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class MessageConsumer {

    @Value("${server.port}")
    public  String port;

    @StreamListener(Sink.INPUT)
    public void reciveInput(Message<String> message){
        System.out.println("消费者1号，接受："+message.getPayload()+"\t port:"+port);
    }
}
