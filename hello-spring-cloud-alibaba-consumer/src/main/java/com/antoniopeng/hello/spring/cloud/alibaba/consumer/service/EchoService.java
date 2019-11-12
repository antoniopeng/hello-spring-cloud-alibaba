package com.antoniopeng.hello.spring.cloud.alibaba.consumer.service;

import com.antoniopeng.hello.spring.cloud.alibaba.consumer.service.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-provider", fallback = EchoServiceFallback.class)
public interface EchoService {

    @GetMapping(value = "/echo/{keyword}")
    String echo(@PathVariable(value = "keyword") String keyword);

}
