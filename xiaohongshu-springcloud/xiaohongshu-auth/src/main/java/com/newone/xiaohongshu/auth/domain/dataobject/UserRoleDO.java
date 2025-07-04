package com.newone.xiaohongshu.auth.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户角色表(t_user_role_rel)
 *
 * @author liuwh
 * @date 2025-07-02 15:55:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRoleDO implements Serializable {
    private static final long serialVersionUID = 7822221370876580516L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除(0：未删除 1：已删除)
     */
    private Boolean isDeleted;
}