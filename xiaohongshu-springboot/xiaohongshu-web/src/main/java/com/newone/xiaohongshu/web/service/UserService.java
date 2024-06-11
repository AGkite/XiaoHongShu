package com.newone.xiaohongshu.web.service;


import com.newone.xiaohongshu.common.utils.Response;
import com.newone.xiaohongshu.web.model.vo.user.FindUserInfoReqVO;

public interface UserService {
    /**
     * 获取当前登录用户名
     */
    Response findUserName();

    /**
     * 获取当前登录用户信息
     */
    Response findUserInfo(FindUserInfoReqVO findUserInfoReqVO);
}
