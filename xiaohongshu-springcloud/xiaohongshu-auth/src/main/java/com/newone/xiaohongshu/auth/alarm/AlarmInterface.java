package com.newone.xiaohongshu.auth.alarm;

public interface AlarmInterface {

    /**
     * 发送系统告警信息
     *
     * @param message
     * @return boolean
     */
    boolean send(String message);
}
