package com.fina.lrps.service;

import com.fina.lrps.domain.Notice;

import java.util.Map;

public interface EmailService {

    /**
     * 发通知
     * @param notice 通知
     * @return 状态码, 错误信息
     */
    Map<String, Object> sendEmail(Notice notice);

    /**
     * 内部发通知
     * @param notice 通知
     * @return 失败人id, 若无则为success
     */
    String[] sendEmailOnPlatform(Notice notice);

    /**
     * 外部发通知
     * @param notice 通知
     * @return 失败人id, 若无则为success
     */
    String[] sendEmailOnMailbox(Notice notice);

}
