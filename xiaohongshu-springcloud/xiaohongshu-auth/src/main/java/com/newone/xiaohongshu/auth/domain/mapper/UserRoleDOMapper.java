package com.newone.xiaohongshu.auth.domain.mapper;

import com.newone.xiaohongshu.auth.domain.dataobject.UserRoleDO;

/**
 * 针对表【t_user_role_rel（用户角色表）】的数据库操作Mapper
 *
 * @author liuwh
 * @createDate 2025-07-02 15:55
 */
public interface UserRoleDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRoleDO row);

    int insertSelective(UserRoleDO row);

    UserRoleDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRoleDO row);

    int updateByPrimaryKey(UserRoleDO row);
}