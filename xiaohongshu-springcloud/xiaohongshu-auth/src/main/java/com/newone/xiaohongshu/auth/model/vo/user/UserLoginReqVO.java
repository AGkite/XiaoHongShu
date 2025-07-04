package com.newone.xiaohongshu.auth.model.vo.user;

import com.newone.framework.common.validator.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录（支持密码或验证码两种方式）
 *
 * @author liuwh
 * @date 2025/07/01 17:29:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginReqVO {

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @PhoneNumber
    private String phone;

    /**
     * 验证码
     */
    private String code;

    /**
     * 密码
     */
    private String password;

    /**
     * 登陆类型：1-手机号，2-帐号密码
     */
    @NotNull(message = "登陆类型不能为空")
    private Integer type;

}
