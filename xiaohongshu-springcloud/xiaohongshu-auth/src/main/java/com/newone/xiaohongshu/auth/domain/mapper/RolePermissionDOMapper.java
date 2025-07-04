package com.newone.xiaohongshu.auth.domain.mapper;

import com.newone.xiaohongshu.auth.domain.dataobject.RolePermissionDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 针对表【t_role_permission_rel（用户权限表）】的数据库操作Mapper
 *
 * @author liuwh
 * @createDate 2025-07-02 15:55
 */
public interface RolePermissionDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RolePermissionDO row);

    int insertSelective(RolePermissionDO row);

    RolePermissionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermissionDO row);

    int updateByPrimaryKey(RolePermissionDO row);

    /**
     * 根据角色 ID 集合批量查询
     * @param roleIds
     * @return
     */
    List<RolePermissionDO> selectByRoleIds(@Param("roleIds") List<Long> roleIds);
}