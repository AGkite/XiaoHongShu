package com.newone.xiaohongshu.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.Optional;

/**
 * 登录类型枚举
 *
 * @author liuwh
 * @date 2025/07/01 17:31:05
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {
    // 验证码
    VERIFICATION_CODE(1),
    //密码
    PASSWORD(2),
    ;

    private final Integer value;

    public static LoginTypeEnum valueOf(Integer code) {
        for (LoginTypeEnum loginTypeEnum : LoginTypeEnum.values()) {
            if (Objects.equals(loginTypeEnum.getValue(), code)) {
                return loginTypeEnum;
            }
        }
        return null;
    }

}
