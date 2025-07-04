package com.newone.xiaohongshu.auth.alarm;

import com.newone.xiaohongshu.auth.alarm.impl.MailAlarmHelper;
import com.newone.xiaohongshu.auth.alarm.impl.SmsAlarmHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class AlarmConfig {

    private static final String SMS_TYPE = "sms";

    private static final String MAIL_TYPE = "mail";

    @Value("${alarm.type}")
    private String alarmType;

    @Bean
    @RefreshScope
    public AlarmInterface alarmHelper() {
        // 根据配置文件中的告警类型，初始化选择不同的告警实现类
        switch (alarmType) {
            case SMS_TYPE:
                return new SmsAlarmHelper();
            case MAIL_TYPE:
                return new MailAlarmHelper();
            default:
                throw new IllegalArgumentException("错误的告警类型...");
        }
    }


}
