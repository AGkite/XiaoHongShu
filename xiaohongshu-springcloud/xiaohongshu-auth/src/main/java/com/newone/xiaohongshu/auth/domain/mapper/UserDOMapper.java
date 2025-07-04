package com.newone.xiaohongshu.auth.domain.mapper;


import com.newone.xiaohongshu.auth.domain.dataobject.UserDO;

/**
 * 针对表【t_user（用户表）】的数据库操作Mapper
 *
 * @author liuwh
 * @createDate 2025-07-01 17:20
 */
public interface UserDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDO row);

    int insertSelective(UserDO row);

    UserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDO row);

    int updateByPrimaryKey(UserDO row);

    /**
     * 通过手机号查询用户记录
     * @param phone
     * @return
     */
    UserDO selectByPhone(String phone);
}