package com.antoniopeng.hello.spring.cloud.alibaba.consumer.service.fallback;

import com.antoniopeng.hello.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(String keyword) {
        return "网络超时，请稍后重试";
    }
}
