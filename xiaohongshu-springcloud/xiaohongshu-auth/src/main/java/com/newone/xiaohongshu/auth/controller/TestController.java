package com.newone.xiaohongshu.auth.controller;

import com.newone.framework.biz.operationlog.aspect.ApiOperationLog;
import com.newone.framework.common.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestController {

    @GetMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public Response<String> test(){
        return Response.success("Hello, World!");
    }

    @GetMapping("/test2")
    @ApiOperationLog(description = "测试接口2")
    public Response<User> test2() {
        return Response.success(User.builder()
                        .nickName("newone")
                        .createTime(LocalDateTime.now())
                        .build());
    }
}
