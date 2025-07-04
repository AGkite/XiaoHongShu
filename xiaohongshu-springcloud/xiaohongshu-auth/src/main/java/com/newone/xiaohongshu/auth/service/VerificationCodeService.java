package com.newone.xiaohongshu.auth.service;

import com.newone.framework.common.response.Response;
import com.newone.xiaohongshu.auth.model.vo.veriticationcode.SendVerificationCodeReqVO;

public interface VerificationCodeService {

    /**
     * 发送短信验证码
     * @param sendVerificationCodeReqVO
     * @return
     */
    Response<?> send(SendVerificationCodeReqVO sendVerificationCodeReqVO);
}
