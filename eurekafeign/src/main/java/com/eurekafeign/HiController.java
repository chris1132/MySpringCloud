package com.eurekafeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangchaohui on 2017/9/11.
 */
@RestController
public class HiController {

    @Autowired
    public FeignService feignService;

    @RequestMapping(value="/hi",method= RequestMethod.GET)
    public String hi(@RequestParam("name") String name){
        return feignService.sayHiFromClientOne(name);
    }
}
