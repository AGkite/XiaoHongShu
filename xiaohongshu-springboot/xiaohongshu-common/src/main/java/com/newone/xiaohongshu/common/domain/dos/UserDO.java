package com.newone.xiaohongshu.common.domain.dos;

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
    private Long userId;
    private String userName;
    private String password;
    private char gender;
    private LocalDate birthday;
    private String phone;
    private String avatar;
    private String background;
    private String summary;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private boolean isDeleted;

}
