package com.newone.xiaohongshu.web.controller;

import com.newone.xiaohongshu.common.aspect.ApiOperationLog;
import com.newone.xiaohongshu.common.domain.dos.UserDO;
import com.newone.xiaohongshu.common.domain.mapper.UserMapper;
import com.newone.xiaohongshu.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api("test")
public class TestController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/user/test")
    @ApiOperationLog(description = "测试接口")
    @ApiOperation(value = "测试接口")
    public Response test(@RequestBody @Validated UserDO user) {
        userMapper.insert(user);
        return Response.success(user);
    }
}
