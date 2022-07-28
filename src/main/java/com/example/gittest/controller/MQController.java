package com.example.gittest.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/produce/{message}")
    public void produce(@PathVariable String message) {
        rabbitTemplate.convertAndSend("mq_test", message);
    }
}
