package com.newone.xiaohongshu.common.enums;

import com.newone.xiaohongshu.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR("10000", "出错啦，后台小哥正在努力修复中..."),
    PARAM_NOT_VALID("10001", "参数错误"),

    // ----------- 业务异常状态码 -----------
    LOGIN_FAIL("20000", "登录失败"),
    USERNAME_OR_PWD_ERROR("20001", "用户名或密码错误"),
    CATEGORY_NAME_IS_EXISTED("20002", "该社区分类已存在，请勿重复添加！"),
    UNAUTHORIZED("20003", "无访问权限，请先登录！"),
    FORBIDDEN("20004", "演示账号仅支持查询操作！"),
    USERNAME_NOT_FOUND("20005", "该用户不存在"),
    ;

    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

}