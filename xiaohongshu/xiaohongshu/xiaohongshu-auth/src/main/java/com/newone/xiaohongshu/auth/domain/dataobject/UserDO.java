package com.newone.xiaohongshu.auth.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户测试表(t_user)
 *
 * @author liuwh
 * @date 2025-06-26 22:18:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDO implements Serializable {
    private static final long serialVersionUID = -5273351573825087126L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}