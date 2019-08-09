package com.bs.producer.hello;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-HELLOWORLD")
public interface HelloWorldService {
    //服务中方法的映射路径 @RequestParam必须指定
    @RequestMapping("helloWorld")
    String helloWorld(@RequestParam("name") String name);
}
