package com.newone.xiaohongshu.auth.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色表(t_role)
 *
 * @author liuwh
 * @date 2025-07-02 15:55:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDO implements Serializable {
    private static final long serialVersionUID = -6214744629563403422L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色唯一标识
     */
    private String roleKey;

    /**
     * 状态(0：启用 1：禁用)
     */
    private Integer status;

    /**
     * 管理系统中的显示顺序
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后一次更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除(0：未删除 1：已删除)
     */
    private Boolean isDeleted;
}