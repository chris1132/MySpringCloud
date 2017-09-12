package com.eurekafeign;

import org.springframework.stereotype.Component;

/**
 * Created by wangchaohui on 2017/9/11.
 */

@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

}
