package com.newone.xiaohongshu.auth.domain.mapper;

import com.newone.xiaohongshu.auth.domain.dataobject.RoleDO;

import java.util.List;

/**
 * 针对表【t_role（角色表）】的数据库操作Mapper
 *
 * @author liuwh
 * @createDate 2025-07-02 15:55
 */
public interface RoleDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleDO row);

    int insertSelective(RoleDO row);

    RoleDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleDO row);

    int updateByPrimaryKey(RoleDO row);

    List<RoleDO> selectEnabledList();
}