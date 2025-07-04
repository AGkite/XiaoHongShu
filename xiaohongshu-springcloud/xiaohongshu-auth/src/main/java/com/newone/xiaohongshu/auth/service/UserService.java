package com.newone.xiaohongshu.auth.service;

import com.newone.framework.common.response.Response;
import com.newone.xiaohongshu.auth.model.vo.user.UserLoginReqVO;

public interface UserService {

    /**
     * 登录与注册
     * @param userLoginReqVO
     * @return
     */
    Response<?> loginAndRegister(UserLoginReqVO userLoginReqVO);
}
