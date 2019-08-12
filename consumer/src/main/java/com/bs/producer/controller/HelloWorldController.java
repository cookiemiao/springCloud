package com.bs.producer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bs.producer.hello.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloWorldController {
    @Autowired
    HelloWorldService helloWorldService;

    /**
     * helloWorld
     *
     * @param name
     * @return
     */
    @GetMapping("helloWorld")
    @SentinelResource(value = "helloWorld", blockHandler = "helloWorldFallback")
    public String helloWorld(String name) throws Exception{
        // 为了使返回时间按比较长
//        Thread.sleep(50);
        name = Optional.ofNullable(name).orElse("noName");
        return helloWorldService.helloWorld(name);
    }

    /**
     * helloWorld限流处理,入参必须一致，最后再加上BlockException,返回类型也必须一样
     *
     * @param name
     * @param ex
     * @return
     */
    public String helloWorldFallback(String name, BlockException ex){

        return "helloWorldFallback";
    }

}
