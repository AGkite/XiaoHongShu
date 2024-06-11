package com.newone.xiaohongshu.web.controller;

import com.newone.xiaohongshu.common.aspect.ApiOperationLog;
import com.newone.xiaohongshu.common.utils.Response;
import com.newone.xiaohongshu.web.model.vo.user.FindUserInfoReqVO;
import com.newone.xiaohongshu.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
@Api(tags = "用户模块")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/name")
    @ApiOperation(value = "查询用户名")
    @ApiOperationLog(description = "查询用户名")
    public Response findUserName() {
        return userService.findUserName();
    }

    @PostMapping("/info")
    @ApiOperation(value = "查询用户信息")
    @ApiOperationLog(description = "查询用户信息")
    public Response findUserInfo(@RequestBody @Validated FindUserInfoReqVO findUserInfoReqVO) {
        return userService.findUserInfo(findUserInfoReqVO);
    }
}
