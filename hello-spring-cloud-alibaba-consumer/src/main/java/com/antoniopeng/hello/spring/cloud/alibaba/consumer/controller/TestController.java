package com.antoniopeng.hello.spring.cloud.alibaba.consumer.controller;

import com.antoniopeng.hello.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@RestController
public class TestController {

    private final RestTemplate restTemplate;

    @Qualifier("echoServiceFallback")
    @Autowired
    private EchoService echoService;

    @Autowired
    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/echo/{keyword}")
    public String echo(@PathVariable(value = "keyword") String keyword) {
        return restTemplate.getForObject("http://service-provider/echo/" + keyword, String.class);
    }

    @GetMapping(value = "/feign/echo/{keyword}")
    public String echoFeign(@PathVariable(value = "keyword") String keyword) {
        return echoService.echo(keyword);
    }

}
