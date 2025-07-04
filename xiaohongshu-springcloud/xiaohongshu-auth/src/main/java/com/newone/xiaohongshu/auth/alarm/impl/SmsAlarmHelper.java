package com.newone.xiaohongshu.auth.alarm.impl;

import com.newone.xiaohongshu.auth.alarm.AlarmInterface;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsAlarmHelper implements AlarmInterface {
    /**
     * 发送系统告警信息
     *
     * @param message
     * @return boolean
     */
    @Override
    public boolean send(String message) {
        log.info("==> 【短信告警】: {}", message);

        // todo

        return false;
    }
}
