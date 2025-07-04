package com.newone.xiaohongshu.auth.domain.mapper;

import com.newone.xiaohongshu.auth.domain.dataobject.PermissionDO;
import com.newone.xiaohongshu.auth.domain.dataobject.RolePermissionDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 针对表【t_permission（权限表）】的数据库操作Mapper
 *
 * @author liuwh
 * @createDate 2025-07-02 15:55
 */
public interface PermissionDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PermissionDO row);

    int insertSelective(PermissionDO row);

    PermissionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PermissionDO row);

    int updateByPrimaryKey(PermissionDO row);

    /**
     * 查询 APP 端所有被启用的权限
     * @return
     */
    List<PermissionDO> selectAppEnabledList();
}