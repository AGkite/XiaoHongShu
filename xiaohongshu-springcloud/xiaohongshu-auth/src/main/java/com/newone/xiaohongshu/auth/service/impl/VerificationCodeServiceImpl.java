package com.newone.xiaohongshu.auth.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.newone.framework.common.exception.BizException;
import com.newone.framework.common.response.Response;
import com.newone.xiaohongshu.auth.constant.RedisKeyConstants;
import com.newone.xiaohongshu.auth.enums.ResponseCodeEnum;
import com.newone.xiaohongshu.auth.model.vo.veriticationcode.SendVerificationCodeReqVO;
import com.newone.xiaohongshu.auth.service.VerificationCodeService;
import com.newone.xiaohongshu.auth.sms.AliyunSmsHelper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource(name = "taskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Resource
    private AliyunSmsHelper aliyunSmsHelper;

    /**
     * 发送短信验证码
     *
     * @param sendVerificationCodeReqVO
     * @return
     */
    @Override
    public Response<?> send(SendVerificationCodeReqVO sendVerificationCodeReqVO) {
        String phone = sendVerificationCodeReqVO.getPhone();

        String key = RedisKeyConstants.buildVerificationCodeKey(phone);

        // 1. 判断是否存在未过期验证码
        if (redisTemplate.hasKey(key)) {
            throw new BizException(ResponseCodeEnum.VERIFICATION_CODE_SEND_FREQUENTLY);
        }

        // 2. 生成6位数验证码
        String verificationCode = RandomUtil.randomNumbers(6);

        log.info("==> 手机号: {}, 已生成验证码: 【{}】", phone, verificationCode);

        // 3. 异步调用第三方短信服务，向用户发送短信
        threadPoolTaskExecutor.execute(() -> {
            String signName = "阿里云短信测试";
            String templateCode = "SMS_154950909";
            String templateParam = String.format("{\"code\":\"%s\"}", verificationCode);
            aliyunSmsHelper.sendMessage(signName, templateCode, phone, templateParam);
        });

        // 4. 存储验证码到redis,并设置3分钟过期时间
        redisTemplate.opsForValue().set(key, verificationCode, 3, TimeUnit.MINUTES);

        return Response.success();
    }
}
