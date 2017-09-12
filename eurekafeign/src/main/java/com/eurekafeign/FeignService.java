package com.eurekafeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wangchaohui on 2017/9/11.
 */
@FeignClient(value = "eureka-client",fallback = FeignServiceImpl.class)
public interface FeignService {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
