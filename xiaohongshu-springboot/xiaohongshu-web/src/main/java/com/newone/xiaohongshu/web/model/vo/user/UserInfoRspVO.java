package com.newone.xiaohongshu.web.model.vo.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoRspVO {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 背景图片
     */
    private String background;
    /**
     * 简介
     */
    private String summary;
    /**
     * 性别
     */
    private Character gender;
    /**
     * 年龄
     */
    private Integer age;
}
