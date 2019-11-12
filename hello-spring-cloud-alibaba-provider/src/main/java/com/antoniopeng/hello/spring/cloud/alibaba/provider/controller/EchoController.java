package com.antoniopeng.hello.spring.cloud.alibaba.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/echo/{keyword}")
    public  String echo(@PathVariable(value = "keyword") String keyword) {
        return "Hello Nacos Provider " + keyword + "，port：" + port;
    }
}
