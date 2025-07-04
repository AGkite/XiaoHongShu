package com.newone.xiaohongshu.auth.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户权限表(t_role_permission_rel)
 *
 * @author liuwh
 * @date 2025-07-02 15:55:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolePermissionDO implements Serializable {
    private static final long serialVersionUID = -497239182725901606L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID
     */
    private Long permissionId;

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