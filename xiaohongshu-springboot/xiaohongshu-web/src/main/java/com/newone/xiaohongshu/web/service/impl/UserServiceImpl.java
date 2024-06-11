package com.newone.xiaohongshu.web.service.impl;

import com.newone.xiaohongshu.common.domain.dos.UserDO;
import com.newone.xiaohongshu.common.domain.mapper.UserMapper;
import com.newone.xiaohongshu.common.enums.ResponseCodeEnum;
import com.newone.xiaohongshu.common.utils.Response;
import com.newone.xiaohongshu.web.model.vo.user.FindUserInfoReqVO;
import com.newone.xiaohongshu.web.model.vo.user.FindUserNameRspVO;
import com.newone.xiaohongshu.web.model.vo.user.UserInfoRspVO;
import com.newone.xiaohongshu.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 获取当前登录用户信息
     */
    @Override
    public Response findUserName() {
        // 获取存储在 ThreadLocal 中的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 拿到用户名
        String name = authentication.getName();
        log.info("当前登录用户：{}", name);
        return Response.success(FindUserNameRspVO.builder().username(name).build());
    }

    /**
     * 获取当前登录用户信息
     */
    @Override
    public Response findUserInfo(FindUserInfoReqVO findUserInfoReqVO) {
        // 拿到用户名
        String username = findUserInfoReqVO.getUsername();
        log.info("当前登录用户：{}", username);
        // 查询用户信息
        UserDO userDO = userMapper.findByUsername(username);
        if (Objects.isNull(userDO)) {
            return Response.fail(ResponseCodeEnum.USERNAME_NOT_FOUND);
        }
        // 封装返回数据
        UserInfoRspVO userInfoRspVO = UserInfoRspVO.builder()
                .userId(userDO.getUserId())
                .username(userDO.getUsername())
                .avatar(userDO.getAvatar())
                .background(userDO.getBackground())
                .summary(userDO.getSummary())
                .gender(userDO.getGender())
                .age(LocalDate.now().getYear() - userDO.getCreateTime().getYear())
                .build();
        return Response.success(userInfoRspVO);
    }
}
