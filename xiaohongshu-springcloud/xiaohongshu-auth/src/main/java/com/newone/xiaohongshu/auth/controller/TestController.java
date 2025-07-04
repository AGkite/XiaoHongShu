package com.newone.xiaohongshu.auth.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.newone.xiaohongshu.auth.alarm.AlarmInterface;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @NacosValue(value = "${rate-limit.api.limit}", autoRefreshed = true)
    private Integer limit;

    @Resource
    private AlarmInterface alarm;

    @GetMapping("/test")
    public String test() {
        return "" + limit;
    }

    @GetMapping("/alarm")
    public String sendAlarm() {
        alarm.send("123456789");
        return "alarm success";
    }


}
