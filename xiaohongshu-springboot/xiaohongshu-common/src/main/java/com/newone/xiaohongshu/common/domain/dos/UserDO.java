package com.newone.xiaohongshu.common.domain.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_user")
public class UserDO {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别：M：男，F：女
     */
    private Character gender;
    /**
     * 生日
     */
    private LocalDate birthday;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 主页背景地址
     */
    private String background;
    /**
     * 个人简介
     */
    private String summary;
    /**
     * 账号创建时间
     */
    private LocalDateTime createTime;
    /**
     * 个人信息修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 账号是否被删除
     */
    private boolean isDeleted;
}
