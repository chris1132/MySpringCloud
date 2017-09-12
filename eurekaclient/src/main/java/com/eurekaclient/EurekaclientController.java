package com.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangchaohui on 2017/9/7.
 */

@RestController
public class EurekaclientController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value="/hi")
    public String eureclient(@RequestParam("name") String name){
        return "hi "+name+",i am from port:" +port;
    }
}
