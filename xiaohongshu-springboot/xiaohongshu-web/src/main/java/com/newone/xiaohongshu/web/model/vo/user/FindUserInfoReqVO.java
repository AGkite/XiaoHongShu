package com.newone.xiaohongshu.web.model.vo.user;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询用户信息请求参数")
public class FindUserInfoReqVO {

    @NotBlank(message = "用户名不能为空")
    private String username;

}
